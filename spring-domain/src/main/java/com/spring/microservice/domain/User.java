package com.spring.microservice.domain;

import java.io.Serializable;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/18 8:48 PM
 * @Version 1.0
 **/
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}