package com.spring.microservice.microserviceproject.controller;

import com.spring.microservice.microserviceproject.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 消息转换测试
 * @Author ZWen
 * @Date 2019/2/18 10:06 PM
 * @Version 1.0
 **/
@RestController
public class HttpMessageConverterController {

    @GetMapping("/test/{id}")
    public User user(@PathVariable Long id, @RequestParam(required = false) String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
         return user;
    }

    /**
     * PostMapping consumes 接受类型  相当于Request Header的 Content-Type
     * PostMapping produces 响应类型  相当于Request Header的 Accept
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/user/json/to/properties",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = "application/properties+user")
    public User jsonToProperties(@RequestBody User user) {
        return user;
    }

    @PostMapping(value = "/user/properties/to/json",
            consumes = "application/properties+user",//接受类型，相当于Request Header的 Content-Type
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE //响应类型，相当于Request Header的 Accept
    )
    public User propertiesToJson(@RequestBody User user) {
        return user;
    }
}