package com.spring.microservice.rabbitmq.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/8 6:58 PM
 * @Version 1.0
 **/
@Component
public class SenderDemo {

    private static final Logger logger = LoggerFactory.getLogger(SenderDemo.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        logger.error("send to demoKey,msg:{}", msg);
        amqpTemplate.convertAndSend("demoKey", msg);
    }

}