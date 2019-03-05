package com.spring.microservice.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/20 4:25 PM
 * @Version 1.0
 **/
@SpringBootApplication
public class SpringWebfluxApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringWebfluxApplication.class);
        springApplication.run(args);
    }
}