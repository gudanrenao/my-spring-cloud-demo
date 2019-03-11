package com.spring.microservice.rabbitmq.demo.config;

import com.spring.microservice.rabbitmq.demo.RabbitmqDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest(classes = RabbitmqDemoApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SenderDemoTest {

    @Autowired
    private SenderDemo senderDemo;

    @Test
    public void send() {
        String msg = "hello world!!!";
        senderDemo.send(msg);
    }
}