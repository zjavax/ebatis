//package io.manbang.ebatis.spring.cluster;
//
//import io.manbang.ebatis.core.cluster.Cluster;
//import io.manbang.ebatis.core.cluster.ClusterRouter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableConfigurationProperties(EbatisProperties.class)
//public class EbatisAutoConfigure {
//
////    @Autowired
////    private EbatisProperties ebatisProperties;
////
//////    @Bean(destroyMethod = "close")
////    @Bean
////    public ClusterRouter clusterRouter() {
////        Cluster cluster = Cluster.simple(ebatisProperties.getLocalhost(), ebatisProperties.getIp());
////        ClusterRouter clusterRouter = ClusterRouter.single(cluster);
////        return clusterRouter;
////    }
//
//}
