package com.spring.microservice.feign.provider.api;

import com.spring.microservice.feign.common.api.UserService;
import com.spring.microservice.feign.common.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/7 12:46 AM
 * @Version 1.0
 **/
@RestController
public class UserController implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public String hello() {
        return "hello,world!!!";
    }

    @Override
    public User findByName(String name) {
        try {
            int nextInt = new Random().nextInt(1000);
            Thread.sleep(nextInt);
            logger.error("findByName sleep {} ms" ,nextInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User(name, 1);
    }

    @Override
    public User header(int age, User user) {
        return new User(user.getName() == null ? "default name" : user.getName(), age);
    }

    /**
     * 使用zuul代理访问的接口，默认会过滤掉下面三个请求头
     * private Set<String> sensitiveHeaders = new LinkedHashSet<>(
     * 			Arrays.asList("Cookie", "Set-Cookie", "Authorization"));
     * @param accessToken
     * @param authorization
     * @return
     */
    @GetMapping("/demo")
    public String demo(@RequestHeader(required = false) String accessToken,
                       @RequestHeader(required = false, name = "Authorization") String authorization,
                       HttpServletRequest request) {
        logger.error("accessToken[{}] , Authorization[{}]", accessToken, authorization);
        return "demo success";
    }


    @GetMapping("/errorDemo")
    public String errorDemo(){
        throw new RuntimeException("test error");
    }

    @GetMapping("/threadSleep")
    public String threadDemo() throws InterruptedException {
       Thread.sleep(3000);
       return "threadSleep";
    }
}