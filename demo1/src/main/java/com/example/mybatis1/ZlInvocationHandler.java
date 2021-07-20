package com.example.mybatis1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ZlInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        boolean annotationPresent = method.isAnnotationPresent(Select.class);
        if(annotationPresent) {
            Select select = method.getAnnotation(Select.class);
            String sql = select.value()[0];
            System.out.println("sql==" + sql);
        }

        return null;
    }
}
