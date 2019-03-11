package com.spring.microservice.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Set;

/**
 * @Description 定时刷新config
 * @Author ZWen
 * @Date 2019/2/23 11:23 PM
 * @Version 1.0
 **/
@Configuration
public class RefreshConfigScheduled {

    private static final Logger logger = LoggerFactory.getLogger(RefreshConfigScheduled.class);

    private final ContextRefresher contextRefresher;

    public RefreshConfigScheduled(ContextRefresher contextRefresher) {
        this.contextRefresher = contextRefresher;
    }

//    @Scheduled(fixedRate = 300 * 1000,initialDelay = 3000)
//    public void refreshConfig(){
//        Set<String> stringSet = contextRefresher.refresh();
//        if(!stringSet.isEmpty()){
//            logger.error("刷新 config server 配置内容为：{}",stringSet);
//        } else {
//            logger.info("没有config内容变化");
//        }
//    }
}