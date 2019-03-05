package com.spring.microservice.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/2/24 6:41 PM
 * @Version 1.0
 **/
@Configuration
public class MyHealthIndicator extends AbstractHealthIndicator {

    /**
     * Actual health check logic.
     *
     * @param builder the {@link Builder} to report health status and details
     * @throws Exception any {@link Exception} that should create a {@link Status#DOWN}
     *                   system status.
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        System.err.println("MyHealthIndicator doHealthCheck");
        builder.withDetail("hello","world").withDetail("MyHealthIndicator","zw666").up();
    }
}