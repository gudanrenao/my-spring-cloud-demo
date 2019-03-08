package com.spring.microservice.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/20 4:25 PM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class SpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringCloudConfigServerApplication.class);
        springApplication.run(args);
    }
}