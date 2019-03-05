package com.spring.microservice.hystrix.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.spring.microservice.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

/**
 * @Description observableExecutionMode 注解参数控制同步还是异步
 * @Author ZWen
 * @Date 2019/3/4 2:57 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/observable")
public class HystrixObservableCommandController {

    private static final Logger logger = LoggerFactory.getLogger(HystrixObservableCommandController.class);

    private final RestTemplate restTemplate;

    public HystrixObservableCommandController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/user/{id}")
    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand(observableExecutionMode = ObservableExecutionMode.LAZY)
    public ResponseVO user(@PathVariable Long id) throws ExecutionException, InterruptedException {

        //todo:如何实现？

        logger.error("when queue,.......................");

        return ResponseVO.buildSuccess();
    }


}