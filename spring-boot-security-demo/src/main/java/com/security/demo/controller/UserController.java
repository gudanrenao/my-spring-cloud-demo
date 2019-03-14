package com.security.demo.controller;


import com.security.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/13 2:27 PM
 * @Version 1.0
 **/
@RestController
public class UserController {

    private static final Random random = new Random();

    @GetMapping("user/{name}")
    public User user(@PathVariable String name) {
        return new User((long) random.nextInt(1000), name);
    }

    @GetMapping("/demo")
    public String demo(@RequestParam(required = false) String name) {
        return "demo : " + String.valueOf(name);
    }
}