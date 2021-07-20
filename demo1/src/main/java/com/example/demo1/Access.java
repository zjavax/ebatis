package com.example.demo1;

public interface Access {
    /**
     * 初始化配置
     */
    void start();

    /**
     * 销毁配置
     */
    void stop();

    enum Type{
        REST,
        RPC
    }
}

