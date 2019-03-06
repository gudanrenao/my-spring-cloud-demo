package com.spring.microservice.feign.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/7 12:28 AM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignProviderApplication.class, args);
    }
}