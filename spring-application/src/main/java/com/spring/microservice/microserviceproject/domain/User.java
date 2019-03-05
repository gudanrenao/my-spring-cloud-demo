package com.spring.microservice.microserviceproject.domain;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/18 8:48 PM
 * @Version 1.0
 **/
public class User {

    private Long id;

    private String name;

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
}