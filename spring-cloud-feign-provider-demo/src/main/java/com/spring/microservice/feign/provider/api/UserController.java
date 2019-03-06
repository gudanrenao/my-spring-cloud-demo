package com.spring.microservice.feign.provider.api;

import com.spring.microservice.feign.common.api.UserService;
import com.spring.microservice.feign.common.dto.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/7 12:46 AM
 * @Version 1.0
 **/
@RestController
public class UserController implements UserService {

    @Override
    public String hello() {
        return "hello,world!!!";
    }

    @Override
    public User findByName(String name) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User(name, 1);
    }

    @Override
    public User header(int age, User user) {
        return new User(user.getName() == null ? "default name" : user.getName(), age);
    }
}