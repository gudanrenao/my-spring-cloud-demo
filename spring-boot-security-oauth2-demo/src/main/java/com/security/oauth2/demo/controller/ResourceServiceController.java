package com.security.oauth2.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 资源地址
 * @Author ZWen
 * @Date 2019/3/12 9:41 PM
 * @Version 1.0
 **/
@RestController
public class ResourceServiceController {

    @GetMapping("/user/{id}")
    public String user(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "user id : " + id;
    }

    @GetMapping("/demo")
    public String demo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "demo success";
    }
}