package com.example.mybatis1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableMybatis1(location="com.example.mybatis1")
public class Demo1Application {

    @Autowired
    TestDao testDao;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @GetMapping("/a")
    String get() {
        testDao.query();
        return "123";
    }





}
