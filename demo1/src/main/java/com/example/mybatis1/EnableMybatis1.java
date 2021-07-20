package com.example.mybatis1;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(ZlImportBeanDefinitionRegistrar.class)
public @interface EnableMybatis1 {

    String location();

}

