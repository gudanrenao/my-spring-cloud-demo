package com.spring.microservice.gateway.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.server.ServerWebExchange;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/9 3:57 PM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
//@EnableHystrix
public class GatewayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayDemoApplication.class, args);
    }

//
//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder){
//
//        return builder.routes().route("test", r ->
//                r.method(HttpMethod.POST)
//                .uri("").predicate(ServerWebExchange::isNotModified)
//                ).build();
//    }
}