package com.example.ebatisspringsample;

import com.example.ebatisspringsample.entity.RecentOrder;
import com.example.ebatisspringsample.mapper.RecentOrderGetMapper;
import io.manbang.ebatis.spring.annotation.EnableEasyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEasyMapper(basePackages = "com.example.ebatisspringsample")
@RestController
public class EbatisSpringSampleApplication {

    @Autowired
    private RecentOrderGetMapper recentOrderGetMapper;

    public static void main(String[] args) {
        SpringApplication.run(EbatisSpringSampleApplication.class, args);
    }

    @GetMapping("/a")
    String get() {
        RecentOrder recentOrder = recentOrderGetMapper.getRecentOrder("10124512292666");
        System.out.println(recentOrder.getCargoId());

        return recentOrder.getDriverUserName();
    }



}
