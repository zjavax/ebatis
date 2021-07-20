package com.example.demo1;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(AccessImportSelector.class)
public @interface EnableAccess {
    /**
     * 接入类型
     * @return
     */
    Access.Type type();
}

