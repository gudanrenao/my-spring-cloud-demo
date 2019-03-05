package com.spring.microservice.webflux.controller;

import com.spring.microservice.domain.User;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/20 4:31 PM
 * @Version 1.0
 **/
@RestController
public class UserController {

    @GetMapping("/user")
    public User index(@RequestParam String name) {
        boolean numeric = StringUtils.isNumeric("12");
        int length = ArrayUtils.getLength(null);
        return new User(1L, name);
    }
}