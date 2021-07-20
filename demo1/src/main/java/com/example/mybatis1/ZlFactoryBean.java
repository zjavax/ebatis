package com.example.mybatis1;

import org.springframework.beans.factory.FactoryBean;

public class ZlFactoryBean implements FactoryBean {

    Class mapperInterface;

    public void setMapperInterface(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object getObject() throws Exception {
        Object o = com.example.mybatis1.ZlSqlSession.getMapper(mapperInterface);
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }
}
