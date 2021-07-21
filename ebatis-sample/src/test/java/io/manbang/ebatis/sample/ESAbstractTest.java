package io.manbang.ebatis.sample;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.manbang.ebatis.core.common.ObjectMapperHolder;
import io.manbang.ebatis.core.proxy.MapperProxyFactory;
import io.manbang.ebatis.sample.cluster.SampleClusterRouterProvider;

/**
 * @author weilong.hu
 * @since 2020/6/29 16:59
 */
abstract class ESAbstractTest {

    protected <R> R createEsMapper(Class<R> mapperClass) {
        // ClusterRouterProvider ？
        return MapperProxyFactory.getMapperProxy(mapperClass, SampleClusterRouterProvider.SAMPLE_CLUSTER_NAME);
    }


    protected String getJsonResult(Object object) throws JsonProcessingException {
        return ObjectMapperHolder.objectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

}
