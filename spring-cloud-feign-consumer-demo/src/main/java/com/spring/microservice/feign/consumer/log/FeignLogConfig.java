package com.spring.microservice.feign.consumer.log;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/7 1:24 AM
 * @Version 1.0
 **/
@Configuration
public class FeignLogConfig {

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}