package com.spring.microservice.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/25 2:31 PM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProviderDemoApplication.class,args);
    }
}