package com.spring.microservice.service.api;

import com.spring.microservice.domain.User;

import java.util.Collection;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/25 2:45 PM
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return 成功返回true,否则返回false
     */
    boolean save(User user);

    /**
     * 获取所有用户
     * @return
     */
    Collection findAll();

    /**
     * 获取某个用户信息
     * @param id
     * @return
     */
    User findById(Long id);
}
