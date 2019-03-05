package com.spring.microservice.user.provider.repository;

import com.spring.microservice.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/25 2:33 PM
 * @Version 1.0
 **/
@Repository
public class UserRepository {

    private Map<Long, User> repository = new ConcurrentHashMap<>(4);
    private AtomicLong idGenerator = new AtomicLong(1);

    public boolean save(User user) {
        Long id = generateId();
        user.setId(id);
        return repository.putIfAbsent(id, user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }

    private Long generateId() {
        return idGenerator.getAndAdd(1);
    }

    public User findById(Long id) {
        return repository.get(id);
    }
}