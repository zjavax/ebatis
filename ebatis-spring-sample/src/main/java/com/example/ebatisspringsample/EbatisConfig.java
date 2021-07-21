package com.example.ebatisspringsample;

import com.example.ebatisspringsample.entity.RecentOrder;
import com.example.ebatisspringsample.mapper.RecentOrderGetMapper;
import io.manbang.ebatis.core.cluster.Cluster;
import io.manbang.ebatis.core.cluster.ClusterRouter;
import io.manbang.ebatis.core.cluster.Credentials;
import io.manbang.ebatis.spring.annotation.EnableEasyMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@EnableEasyMapper(basePackages = "com.example.ebatisspringsample")
public class EbatisConfig {
    @Bean(destroyMethod = "close")
    public ClusterRouter clusterRouter() {
        Cluster cluster = Cluster.simple("47.100.120.240", 9200);
        ClusterRouter clusterRouter = ClusterRouter.single(cluster);
        return clusterRouter;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(EbatisConfig.class);
        RecentOrderGetMapper recentOrderGetMapper = context.getBean(RecentOrderGetMapper.class);
        RecentOrder recentOrder = recentOrderGetMapper.getRecentOrder("4ggnXLTnQF2tQVh9U7H7fA");
        System.out.println(recentOrder.getCargoId());
    }
}
