package com.spring.microservice.webflux.controller;

import com.spring.microservice.dto.UserValidation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/21 9:49 PM
 * @Version 1.0
 **/
@RestController
public class CustomValidTestController {

    @PostMapping("/customValid")
    public UserValidation index(@Valid @RequestBody UserValidation userValidation) {
        return userValidation;
    }
}