package com.spring.microservice.rabbitmq.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/9 10:05 AM
 * @Version 1.0
 **/
@Component
@RabbitListener(queues = {"demoKey"})
public class ReceiverDemo {

    private static final Logger logger = LoggerFactory.getLogger(ReceiverDemo.class);

    @RabbitHandler
    public void receive(String msg) {
        logger.error("receive from demoKey,msg:{}", msg);
    }

}