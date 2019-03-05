package com.spring.microservice.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/20 4:25 PM
 * @Version 1.0
 **/
@SpringCloudApplication
@EnableConfigServer
public class SpringCloudConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringCloudConfigServerApplication.class);
        springApplication.run(args);
    }
}