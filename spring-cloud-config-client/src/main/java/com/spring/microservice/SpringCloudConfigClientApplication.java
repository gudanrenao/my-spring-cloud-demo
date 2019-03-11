package com.spring.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Description config    bus-amqp
 * @Author ZWen
 * @Date 2019/2/20 4:25 PM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
public class SpringCloudConfigClientApplication {

    /**
     * todo:Web Hook报异常 /actuator/bus-refresh
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringCloudConfigClientApplication.class);
        springApplication.run(args);
    }
}