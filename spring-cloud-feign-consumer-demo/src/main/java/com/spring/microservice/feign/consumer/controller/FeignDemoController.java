package com.spring.microservice.feign.consumer.controller;

import com.spring.microservice.feign.common.dto.User;
import com.spring.microservice.feign.consumer.service.UserServiceFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/7 12:39 AM
 * @Version 1.0
 **/
@RestController
public class FeignDemoController {

    private static final Logger logger = LoggerFactory.getLogger(FeignDemoController.class);

    @Autowired
    private UserServiceFeign userServiceFeign;

    @GetMapping("/test")
    public String test() {
        User user = userServiceFeign.findByName("zw");
        User header = userServiceFeign.header(18, new User("张文", 27));
        String hello = userServiceFeign.hello();
        logger.error("user:{},header:{},hello:{}", user, header, hello);
        return "user:" + user + ",header:" + hello + ",hello:" + hello;
    }

    /**
     * 使用zuul代理访问的接口，默认会过滤掉下面三个请求头
     * private Set<String> sensitiveHeaders = new LinkedHashSet<>(
     * 			Arrays.asList("Cookie", "Set-Cookie", "Authorization"));
     * @param accessToken
     * @param authorization
     * @return
     */
    @GetMapping("/demo")
    public String demo(@RequestHeader(required = false) String accessToken,
                       @RequestHeader(required = false, name = "Authorization") String authorization) {
        logger.error("accessToken[{}] , Authorization[{}]", accessToken, authorization);
        return "demo success";
    }

    @GetMapping("/errorDemo")
    public String errorDemo(){
        throw new RuntimeException("test error");
    }
}