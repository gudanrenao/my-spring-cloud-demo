//package com.spring.microservice.feign.consumer.log;
//
//import com.spring.microservice.feign.common.dto.User;
//import com.spring.microservice.feign.consumer.service.UserServiceFeign;
//
///**
// * @Description
// * @Author ZWen
// * @Date 2019/3/7 1:23 AM
// * @Version 1.0
// **/
//public class UserServiceFeignLog implements UserServiceFeign {
//
//    @Override
//    public String hello() {
//        return "服务降级 hello";
//    }
//
//    @Override
//    public User findByName(String name) {
//        return new User("服务降级-findByName", -1);
//    }
//
//    @Override
//    public User header(int age, User user) {
//        return new User("服务降级-Header", age);
//    }
//}