package com.spring.microservice.feign.consumer.service;

import com.spring.microservice.feign.common.api.UserService;
import com.spring.microservice.feign.common.dto.User;
import com.spring.microservice.feign.consumer.log.FeignLogConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/7 12:32 AM
 * @Version 1.0
 **/
@FeignClient(value = "feign-provider-demo",
//        fallbackFactory = UserServiceFeign.UserServiceFeignFallbackFactory.class,//服务降级
        fallback = UserServiceFeign.UserServiceFallback.class,//服务降级
        configuration = {FeignLogConfig.class} //Feign调用日志
)
public interface UserServiceFeign extends UserService {

    @Component
    /**
     * 注意！！！！！！！！！！！！！！
     * 这里如果使用fallback的方式，需要更改RequestMapping，否则会报RequestMappingHandlerMapping重复
     *  Error creating bean with name 'requestMappingHandlerMapping' defined in ...
     * Ambiguous mapping. Cannot map '...UserServiceFeign' method
     * 建议使用fallbackFactory的方式
     */
    @RequestMapping("/fallback/user")
    class UserServiceFallback implements UserServiceFeign {
        @Override
        public String hello() {
            return "服务降级 hello";
        }

        @Override
        public User findByName(String name) {
            return new User("服务降级-findByName", -1);
        }

        @Override
        public User header(int age, User user) {
            return new User("服务降级-Header", age);
        }
    }


//    @Component
//    class UserServiceFeignFallbackFactory implements FallbackFactory<UserServiceFeign> {
//        @Override
//        public UserServiceFeign create(Throwable cause) {
//            return new UserServiceFeign() {
//
//                @Override
//                public String hello() {
//                    return "服务降级 hello";
//                }
//
//                @Override
//                public User findByName(String name) {
//                    return new User("服务降级-findByName", -1);
//                }
//
//                @Override
//                public User header(int age, User user) {
//                    return new User("服务降级-Header", age);
//                }
//            };
//        }
//    }
}