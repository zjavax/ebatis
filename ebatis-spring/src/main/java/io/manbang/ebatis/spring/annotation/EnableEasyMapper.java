package io.manbang.ebatis.spring.annotation;

import io.manbang.ebatis.spring.cluster.SpringClusterRouterProvider;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 启用ebatis
 *
 * @author duoliang.zhang
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Import({EbatisAutoConfigure.class, EasyMapperRegistrar.class, SpringClusterRouterProvider.class})
@Import({EasyMapperRegistrar.class, SpringClusterRouterProvider.class})
public @interface EnableEasyMapper {
    /**
     * 获取需要扫描的包路径
     *
     * @return 待扫描的包路径
     */
    @AliasFor("basePackages")
    String[] value() default {};

    /**
     * 获取需要扫描的包路径
     *
     * @return 待扫描的包路径
     */
    @AliasFor("value")
    String[] basePackages() default {};

    /**
     * 获取集群路由器名称，默认是本地的测试进群，【127.0.0.1:9200】
     *
     * @return 集群路由器名称
     */
    String clusterRouter() default "clusterRouter";
}
