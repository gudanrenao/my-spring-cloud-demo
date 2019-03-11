package com.spring.microservice.gateway.custom.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 使用sevlet实现自定义统一网管
 * @Author ZWen
 * @Date 2019/3/11 8:52 PM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan(basePackages = {"com.spring.microservice.gateway.custom.servlet.gateway"})
public class CustomGatewayServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomGatewayServletApplication.class,args);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}