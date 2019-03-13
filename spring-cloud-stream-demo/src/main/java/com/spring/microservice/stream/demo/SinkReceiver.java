package com.spring.microservice.stream.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @Description 接受RabbitMQ消息的消费者
 * @Author ZWen
 * @Date 2019/3/12 3:11 PM
 * @Version 1.0
 **/
@EnableBinding(Sink.class)
public class SinkReceiver {

    private static final Logger logger = LoggerFactory.getLogger(SinkReceiver.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("SinkReceiver receive : {}", String.valueOf(payload));
    }
}