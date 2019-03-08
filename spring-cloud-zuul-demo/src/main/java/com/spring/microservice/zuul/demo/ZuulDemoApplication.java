package com.spring.microservice.zuul.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/7 5:55 PM
 * @Version 1.0
 **/
@EnableZuulProxy
@SpringBootApplication
public class ZuulDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulDemoApplication.class, args);
    }

    /**
     * 自定义路由映射规则  name-version => /version/name
     * @return
     */
    @Bean
    public PatternServiceRouteMapper patternServiceRouteMapper(){
        return new PatternServiceRouteMapper("(?<name>.*)-(?<version>v.*$)","${version}/${name}");
    }
}