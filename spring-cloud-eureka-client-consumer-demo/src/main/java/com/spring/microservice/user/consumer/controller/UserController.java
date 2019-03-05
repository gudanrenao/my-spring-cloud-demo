package com.spring.microservice.user.consumer.controller;

import com.spring.microservice.domain.User;
import com.spring.microservice.service.api.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/25 3:01 PM
 * @Version 1.0
 **/
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/save")
    public boolean save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/users")
    public Collection findAll() {
        return userService.findAll();
    }
}