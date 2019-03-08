package com.spring.microservice.zuul.demo.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 自定义异常响应信息
 * @Author ZWen
 * @Date 2019/3/8 2:15 PM
 * @Version 1.0
 **/
@Configuration
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        Map<String, Object> head = new HashMap<>(2);
        head.put("errCode", errorAttributes.getOrDefault("status", -1));
        head.put("errMsg", errorAttributes.getOrDefault("msg", "系统繁忙"));
        errorAttributes.put("head", head);
        errorAttributes.put("data", false);
        errorAttributes.remove("exception");
        return errorAttributes;
    }
}