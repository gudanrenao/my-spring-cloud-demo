//package com.spring.microservice.feign.consumer.config;
//
//import feign.Feign;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
///**
// * @Description todo:可以关闭单个FeignClient的hystrix功能?
// * @Author ZWen
// * @Date 2019/3/7 11:15 AM
// * @Version 1.0
// **/
//@Configuration
//public class FeignDisableHystrixConfig {
//
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder builder(){
//        return Feign.builder();
//    }
//}