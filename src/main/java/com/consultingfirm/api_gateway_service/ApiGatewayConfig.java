package com.consultingfirm.api_gateway_service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path(
                                "/api/non-secure/benchprofiles/**",
                                "/api/non-secure/dailysubmissions/**",
                                "/api/non-secure/interviews/**",
                                "/swagger-ui/**",
                                "/v3/api-docs/**")
                        .uri("lb://USER-DETAILS-API-NON-SECURE"))
                .build();
    }
}
