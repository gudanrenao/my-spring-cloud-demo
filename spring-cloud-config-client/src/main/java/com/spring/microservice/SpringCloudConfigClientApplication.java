package com.spring.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/20 4:25 PM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableScheduling
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringCloudConfigClientApplication.class);
        springApplication.run(args);
    }
}