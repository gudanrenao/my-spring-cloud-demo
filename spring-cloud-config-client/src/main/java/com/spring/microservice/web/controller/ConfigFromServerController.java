package com.spring.microservice.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/23 10:38 PM
 * @Version 1.0
 **/
@RestController
@RefreshScope
public class ConfigFromServerController {

    @Value("${my.name}")
    private String name;

    @Value("${user}")
    private String user;

    @Value("${your}")
    private String your;

    @GetMapping("/serverConfig")
    public Map getConfig(){
        Map<String,Object> map = new HashMap<>(4);
        map.put("my.name",name);
        map.put("user",user);
        map.put("your",your);
        return map;
    }

}