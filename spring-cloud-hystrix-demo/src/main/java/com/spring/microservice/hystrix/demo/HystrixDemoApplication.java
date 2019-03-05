package com.spring.microservice.hystrix.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description @EnableHystrix 包含 @EnableCircuitBreaker 作用，而外提供spring cloud 的熔断的功能
 * @Author ZWen
 * @Date 2019/2/28 12:27 PM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
public class HystrixDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDemoApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}