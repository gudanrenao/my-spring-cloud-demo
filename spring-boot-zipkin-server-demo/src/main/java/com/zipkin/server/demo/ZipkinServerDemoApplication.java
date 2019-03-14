package com.zipkin.server.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/14 11:02 AM
 * @Version 1.0
 **/
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerDemoApplication.class, args);
    }
}