package com.example.mybatis1;

public interface TestDao {

    @Select("select * from zx")
    public String query();

}
