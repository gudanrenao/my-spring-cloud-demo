package com.spring.microservice.user.provider.service;

import com.spring.microservice.domain.User;
import com.spring.microservice.service.api.UserService;
import com.spring.microservice.user.provider.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/25 2:47 PM
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 保存用户
     *
     * @param user
     * @return 成功返回true, 否则返回false
     */
    @Override
    public boolean save(User user) {
        return userRepository.save(user);
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @Override
    public Collection findAll() {
        return userRepository.findAll();
    }

    /**
     * 获取某个用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}