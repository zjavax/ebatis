package com.example.mybatis1;

import java.lang.reflect.Proxy;

public class ZlSqlSession {
    public static Object getMapper(Class clazz) {
        Class[] clazzs = new Class[]{clazz};
        Object o = Proxy.newProxyInstance(ZlSqlSession.class.getClassLoader(),
                clazzs, new ZlInvocationHandler());
        return o;
    }
}
