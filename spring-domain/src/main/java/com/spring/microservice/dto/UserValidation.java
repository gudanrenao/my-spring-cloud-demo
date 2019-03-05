package com.spring.microservice.dto;

import com.spring.microservice.annotation.valid.Between;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/21 6:39 PM
 * @Version 1.0
 **/
public class UserValidation {

    @Between(min = 100, max = 1000)
    private Long id;

    private String name;

    private String pwd;

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "UserValidation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}