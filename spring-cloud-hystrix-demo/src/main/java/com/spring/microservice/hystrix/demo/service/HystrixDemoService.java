package com.spring.microservice.hystrix.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.spring.microservice.domain.User;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/4 6:39 PM
 * @Version 1.0
 **/
@Service
public class HystrixDemoService {

    private static final String CACHE_KEY_PREFIX = "cache:";

    /**
     * 注解请求缓存 ${#link }
     *
     * @param user
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    //和HystrixCommand一同使用，回去请求缓存的key
    @CacheResult(cacheKeyMethod = "cacheUser")
//    @CacheResult
    public User indexUser( //如果有了cacheKeyMethod，那么CacheKey将不会生效
                           //可以设置参数对象的内部属性作为key
                           @CacheKey("id")
                                   User user) {
        System.out.println("index running ......................." + user);
        user.setId(user.getId() + 100);
        return user;
    }

    /**
     * key缓存策略
     *
     * @param user
     * @return
     */
    public String cacheUser(User user) {
        return CACHE_KEY_PREFIX + user.getId();
    }

    /**
     * fallback的参数和调用方法一致，还可以多一个异常
     *
     * @param user
     * @return
     */
    public User fallback(User user, Throwable throwable) {
        System.out.println("fallback Throwable  is : " + throwable);
        System.out.println("fallback param name is : " + user.getName());
        return new User(-1L, user.getName());
    }


    /**
     * 清除请求缓存
     *
     * @param user
     */
    @HystrixCommand
    @CacheRemove(cacheKeyMethod = "cacheUser", commandKey = "indexUser")
    public void updateUser(User user) {
        System.out.println("updateUser running ......................." + user);
    }
}