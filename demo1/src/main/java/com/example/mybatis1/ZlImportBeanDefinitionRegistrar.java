package com.example.mybatis1;

import com.example.demo1.Access;
import com.example.demo1.EnableAccess;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ZlImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

//    private Class<? extends MapperFactoryBean> mapperFactoryBeanClass = MapperFactoryBean.class;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //读取EnableAccess中所有的属性方法
        Map<String, Object> annotationAttributes =  importingClassMetadata.getAnnotationAttributes(EnableMybatis1.class.getName());
        //获取属性为type的属性方法
       String location = (String)annotationAttributes.get("location");
       System.out.println(location);

        // 反射  通过包名获取该包下所有的class
        List<Class> clazzs = new ArrayList<>();
        clazzs.add(com.example.mybatis1.TestDao.class);

        for (Class clazz:clazzs) {
            BeanDefinitionBuilder b = BeanDefinitionBuilder.genericBeanDefinition(ZlFactoryBean.class);
            AbstractBeanDefinition bd = b.getBeanDefinition();
            bd.getPropertyValues().add("mapperInterface", clazz);  // TestDao
            registry.registerBeanDefinition(clazz.getName(), bd);

            new RootBeanDefinition(ZlFactoryBean.class);
        }

    }
}
