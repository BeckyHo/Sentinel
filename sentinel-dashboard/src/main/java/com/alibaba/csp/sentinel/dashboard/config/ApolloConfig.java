package com.alibaba.csp.sentinel.dashboard.config;

import com.ctrip.framework.apollo.openapi.client.ApolloOpenApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author chunming.ygy@gmail.com
 * @date 2022/3/4 10:03
 */
public class ApolloConfig {

    @Value("${apollo.portal.url}")
    private String apolloPortalUrl;
    @Value("${apollo.application.token}")
    private String apolloApplicationToken;

    @Bean
    public ApolloOpenApiClient apolloOpenApiClient() {
        return ApolloOpenApiClient.newBuilder()
                .withPortalUrl(apolloPortalUrl)
                .withToken(apolloApplicationToken)
                .build();
    }
}
