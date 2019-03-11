package com.spring.microservice.rabbitmq.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/9 10:17 AM
 * @Version 1.0
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue demoQueue() {
        return new Queue("demoKey");
    }
}