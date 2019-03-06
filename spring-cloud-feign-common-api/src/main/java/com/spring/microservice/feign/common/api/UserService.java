package com.spring.microservice.feign.common.api;

import com.spring.microservice.feign.common.dto.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/6 11:55 PM
 * @Version 1.0
 **/
@RequestMapping("/user")
public interface UserService {

    @GetMapping("/hello")
    String hello();

    @GetMapping("/findByName")
    User findByName(@RequestParam("name") String name);

    @PostMapping("/header")
    User header(@RequestHeader("age") int age, @RequestBody User user);

}
