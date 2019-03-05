package com.spring.microservice.config;

import org.springframework.cloud.bootstrap.config.PropertySourceLocator;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 自定义配置
 * @Author ZWen
 * @Date 2019/2/23 1:56 PM
 * @Version 1.0
 **/
@Order
@Configuration
public class MyPropertyEnvironment implements PropertySourceLocator {

    @Override
    public PropertySource<?> locate(Environment environment) {
        Map<String,Object> map = new HashMap<>(4);
        map.put("custom.name","张文");
        MapPropertySource mapPropertySource = new MapPropertySource("my-custom-propertySource",map);
        return mapPropertySource;
    }
}