package com.example.demo1;

public class RestAccess implements Access{
    @Override
    public void start() {
        System.out.println("rest接入配置");
    }

    @Override
    public void stop() {
        System.out.println("rest接入销毁配置");
    }
}

