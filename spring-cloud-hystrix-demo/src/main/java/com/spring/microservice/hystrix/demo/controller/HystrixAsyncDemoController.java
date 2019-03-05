package com.spring.microservice.hystrix.demo.controller;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.spring.microservice.domain.User;
import com.spring.microservice.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @Description 异步Hystrix Demo 两种方式：继承HystrixCommand和使用HystrixCommand注解
 * @Author ZWen
 * @Date 2019/3/4 2:57 PM
 * @Version 1.0
 **/
@RestController
@RequestMapping("/async")
public class HystrixAsyncDemoController {

    private static final Logger logger = LoggerFactory.getLogger(HystrixAsyncDemoController.class);

    private final RestTemplate restTemplate;

    public HystrixAsyncDemoController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 使用继承HystrixCommand方式
     *
     * @param id
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/user/{id}")
    public ResponseVO user(@PathVariable Long id) throws ExecutionException, InterruptedException {
        MyAsyncHystrixCommandDemo hystrixCommandDemo = new MyAsyncHystrixCommandDemo(HystrixCommandGroupKey.Factory.asKey("findUserById"), restTemplate, id);
        Future<User> userFuture = hystrixCommandDemo.queue();
        logger.error("when queue,.......................");

        User user = userFuture.get();

        return ResponseVO.buildSuccess(user);
    }

    /**
     * 使用注解的方式
     *
     * @param id
     * @return
     */
    @GetMapping("/user2/{id}")
    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
    public ResponseVO user2(@PathVariable final Long id) throws InterruptedException {
        //todo:不知道为什么，并不会异步执行
        AsyncResult<User> asyncResult = new AsyncResult<User>() {
            /**
             * {@inheritDoc}.
             */
            @Override
            public User invoke() {
                User user = restTemplate.getForObject("http://user-service-provider/user?id={1}", User.class, id);
                logger.error("user2 user-service-provider/user: id={},response:{}", id, user);
                return user;
            }

            @Override
            public User get() throws UnsupportedOperationException {
                return invoke();
            }
        };
        Thread.sleep(500);
        logger.error("user2 when queue,.......................");
        return ResponseVO.buildSuccess(asyncResult.get());

    }


    private static class MyAsyncHystrixCommandDemo extends HystrixCommand<User> {

        private final RestTemplate restTemplate;
        private final Long id;

        protected MyAsyncHystrixCommandDemo(HystrixCommandGroupKey group, RestTemplate restTemplate, Long id) {
            super(group);
            this.restTemplate = restTemplate;
            this.id = id;
        }

        @Override
        protected User run() throws Exception {
//            Thread.sleep(500);
            User user = restTemplate.getForObject("http://user-service-provider/user?id={1}", User.class, id);
            logger.error("user1 user-service-provider/user: id={},response:{}", id, user);
            return user;
        }
    }


}