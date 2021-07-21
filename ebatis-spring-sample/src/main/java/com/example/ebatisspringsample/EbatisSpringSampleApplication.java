//package com.example.ebatisspringsample;
//
//import com.example.ebatisspringsample.entity.RecentOrder;
//import com.example.ebatisspringsample.mapper.RecentOrderGetMapper;
//import io.manbang.ebatis.core.cluster.Cluster;
//import io.manbang.ebatis.core.cluster.ClusterRouter;
//import io.manbang.ebatis.core.cluster.Credentials;
//import io.manbang.ebatis.spring.annotation.EnableEasyMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@SpringBootApplication
//@EnableEasyMapper(basePackages="com.example.ebatisspringsample", clusterRouter="47.100.120.240:9200")
//@RestController
//public class EbatisSpringSampleApplication {
//
//    @Autowired
//    private RecentOrderGetMapper recentOrderGetMapper;
//
//    public static void main(String[] args) {
//        SpringApplication.run(EbatisSpringSampleApplication.class, args);
//    }
//
//    @GetMapping("/a")
//    String get() {
//        RecentOrder recentOrder = recentOrderGetMapper.getRecentOrder("4ggnXLTnQF2tQVh9U7H7fA");
//        System.out.println(recentOrder.getCargoId());
//
//        return recentOrder.getDriverUserName();
//    }
//
////    @Bean(destroyMethod = "close")
////    public ClusterRouter clusterRouter() {
////        Cluster cluster = Cluster.simple("47.100.120.240", 9200, Credentials.basic("admin", "123456"));
////        ClusterRouter clusterRouter = ClusterRouter.single(cluster);
////        return clusterRouter;
////    }
//
//    @Bean(destroyMethod = "close")
//    public ClusterRouter clusterRouter() {
//        Cluster cluster = Cluster.simple("47.100.120.240", 9200);
//        ClusterRouter clusterRouter = ClusterRouter.single(cluster);
//        return clusterRouter;
//    }
//
//}
