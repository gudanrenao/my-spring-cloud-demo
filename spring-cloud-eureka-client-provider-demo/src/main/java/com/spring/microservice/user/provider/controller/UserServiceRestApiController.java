package com.spring.microservice.user.provider.controller;

import com.spring.microservice.domain.User;
import com.spring.microservice.service.api.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Description user服务api
 * @Author ZWen
 * @Date 2019/2/25 2:49 PM
 * @Version 1.0
 **/
@RestController
public class UserServiceRestApiController {

    private final UserService userService;

    public UserServiceRestApiController(UserService userService) {
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

    @GetMapping("/user")
    public User findById(@RequestParam Long id){
        return userService.findById(id);
    }
}