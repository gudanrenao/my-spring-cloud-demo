package com.spring.microservice.hystrix.dashboard.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/28 3:27 PM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoardDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoardDemoApplication.class,args);
    }
}