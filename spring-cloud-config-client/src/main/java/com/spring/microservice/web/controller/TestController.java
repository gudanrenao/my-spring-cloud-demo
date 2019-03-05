package com.spring.microservice.web.controller;


import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/22 6:12 PM
 * @Version 1.0
 **/
@RestController
public class TestController {

    private final Environment environment;

    public TestController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/test")
    public String test() {
        return "SUCCESS";
    }

    @GetMapping("/env/get/{name}")
    public String getEnvironment(@PathVariable String name){
        return environment.getProperty(name);
    }


}