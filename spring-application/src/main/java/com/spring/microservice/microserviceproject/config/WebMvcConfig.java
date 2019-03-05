package com.spring.microservice.microserviceproject.config;

import com.spring.microservice.microserviceproject.http.message.PropertiesHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/18 8:51 PM
 * @Version 1.0
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 可以修改message输出的格式的顺序
     * <p>
     * A hook for extending or modifying the list of converters after it has been
     * configured. This may be useful for example to allow default converters to
     * be registered and then insert a custom converter through this method.
     * <p>
     * 用于在配置转换器列表之后扩展或修改该列表的钩子。这可能是有用的，例如允许默认的转换器
     * 注册，然后通过此方法插入自定义转换器
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converters.get(0));
        converters.set(0, new MappingJackson2XmlHttpMessageConverter());
        //添加自定义消息转换器
        converters.add(new PropertiesHttpMessageConverter());
    }

}