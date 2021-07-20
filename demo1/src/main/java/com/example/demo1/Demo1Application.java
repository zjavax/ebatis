package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAccess(type=Access.Type.REST)
public class Demo1Application {

    @Autowired
    Access restAccess;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Demo1Application.class, args);
//        Access access = context.getBean(Access.class);
//        access.start();
//        access.stop();
    }

    @GetMapping("/a")
    String get() {
        restAccess.start();
        return "123";
    }





}

