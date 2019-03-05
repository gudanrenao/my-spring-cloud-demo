package com.spring.microservice.microserviceproject.http.message;

import com.spring.microservice.microserviceproject.domain.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/18 9:56 PM
 * @Version 1.0
 **/
public class PropertiesHttpMessageConverter extends AbstractHttpMessageConverter<User> {

    public PropertiesHttpMessageConverter() {
        super(MediaType.valueOf("application/properties+user"));
        setDefaultCharset(Charset.forName("utf-8"));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(User.class);
    }

    @Override
    protected User readInternal(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        //从request中读取的Properties类型信息，转换为User
        InputStream inputStream = httpInputMessage.getBody();
        User user = new User();
        Properties properties = new Properties();
        properties.load(new InputStreamReader(inputStream,getDefaultCharset()));
        user.setId(Long.valueOf(properties.getProperty("user.id")));
        user.setName(properties.getProperty("user.name"));
        return user;
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        //将内容输出为Properties格式
        OutputStream outputStream = httpOutputMessage.getBody();
        Properties properties = new Properties();
        properties.setProperty("user.id",String.valueOf(user.getId()));
        properties.setProperty("user.name",user.getName());
        properties.store(new OutputStreamWriter(outputStream,getDefaultCharset()),"write from spring server");

    }
}