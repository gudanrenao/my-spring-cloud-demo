package com.security.oauth2.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description todo: 不知为何 访问 /oauth/token?.... 401
 * @Author ZWen
 * @Date 2019/3/12 9:40 PM
 * @Version 1.0
 **/
@SpringBootApplication
public class Oauth2DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2DemoApplication.class, args);
    }
}