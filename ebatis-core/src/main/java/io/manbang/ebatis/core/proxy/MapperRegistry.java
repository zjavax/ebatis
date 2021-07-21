package io.manbang.ebatis.core.proxy;

import io.manbang.ebatis.core.annotation.Mapper;
import io.manbang.ebatis.core.exception.MapperAnnotationNotPresentException;
import io.manbang.ebatis.core.exception.MapperNotAllowInheritException;
import io.manbang.ebatis.core.exception.MapperNotInterfaceException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Mapper接口注解表，所有的接口的动态代理都存在在此
 *
 * @author 章多亮
 * @since 2020/5/25 17:27
 */
class MapperRegistry {
    // 为什么这里使用HashMap
    private static final Map<Class<?>, Object> PROXIES = new HashMap<>();

    private MapperRegistry() {
        throw new UnsupportedOperationException();
    }

    private static synchronized Object createProxy(Class<?> mapperInterface, ClassLoader classLoader, String clusterRouterName) {
        ClassLoader cl = classLoader == null ? mapperInterface.getClassLoader() : classLoader;
        return Proxy.newProxyInstance(cl, new Class[]{mapperInterface}, new MapperProxy(mapperInterface, clusterRouterName));
    }

    @SuppressWarnings("unchecked")
    static <M> M createIfAbsent(Class<M> mapperInterface, ClassLoader classLoader, String clusterRouterName) {
        //  必须是接口，动态代理的要求
        if (!mapperInterface.isInterface()) {
            throw new MapperNotInterfaceException(mapperInterface.toString());
        }

        // 接口不能有继承
        if (mapperInterface.getInterfaces().length > 0) {
            throw new MapperNotAllowInheritException(mapperInterface.toString());
        }

        Annotation[] annotations = mapperInterface.getAnnotations();

        // 必须要有Mapper注解，或者加了Mapper注解的注解在接口上定义
        boolean mapperAnnotationPresent = false;
        for (Annotation annotation : annotations) {
            mapperAnnotationPresent = annotation.annotationType() == Mapper.class || annotation.annotationType().isAnnotationPresent(Mapper.class);
            if (mapperAnnotationPresent) {
                break;
            }
        }

        if (!mapperAnnotationPresent) {
            throw new MapperAnnotationNotPresentException(mapperInterface.toString());
        }

        return (M) PROXIES.computeIfAbsent(mapperInterface, clazz -> createProxy(clazz, classLoader, clusterRouterName));
    }
}
