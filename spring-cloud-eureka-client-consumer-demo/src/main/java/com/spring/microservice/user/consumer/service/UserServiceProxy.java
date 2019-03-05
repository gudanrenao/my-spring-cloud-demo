package com.spring.microservice.user.consumer.service;

import com.spring.microservice.domain.User;
import com.spring.microservice.service.api.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Collection;

/**
 * @Description service代理
 * @Author ZWen
 * @Date 2019/2/25 2:55 PM
 * @Version 1.0
 **/
@Service
public class UserServiceProxy implements UserService {

    private static final String USER_SERVICE_API_NAME = "http://user-service-provider";

    private final RestTemplate restTemplate;

    public UserServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * 保存用户
     *
     * @param user
     * @return 成功返回true, 否则返回false
     */
    @Override
    public boolean save(User user) {
        boolean result = restTemplate.postForObject(USER_SERVICE_API_NAME + "/user/save", user, Boolean.class);
        return result;
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @Override
    public Collection findAll() {
        return restTemplate.getForObject(USER_SERVICE_API_NAME + "/users", Collection.class);
    }

    public void getForEntity() {
        ResponseEntity<Collection> responseEntity = restTemplate.getForEntity(USER_SERVICE_API_NAME + "/users", Collection.class);
        Collection body = responseEntity.getBody();

        ResponseEntity<Boolean> postForEntity = restTemplate.postForEntity(USER_SERVICE_API_NAME + "/user/save?name={1}", null, Boolean.class, "zw");

        URI uri = restTemplate.postForLocation(USER_SERVICE_API_NAME + "/user/save?name={1}", null, "zw");

        restTemplate.put(USER_SERVICE_API_NAME + "/user/update?id={1}", null, 1L);

        restTemplate.delete(USER_SERVICE_API_NAME + "/user/delete?id={1}", 100L);
    }
}