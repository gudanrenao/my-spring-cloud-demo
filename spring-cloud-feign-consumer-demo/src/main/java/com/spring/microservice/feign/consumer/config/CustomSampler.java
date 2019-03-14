package com.spring.microservice.feign.consumer.config;

import brave.sampler.Sampler;

/**
 * @Description 自定义日志输出设置
 * @Author ZWen
 * @Date 2019/3/14 10:28 AM
 * @Version 1.0
 **/
public class CustomSampler extends Sampler {

    /**
     * Returns true if the trace ID should be measured.
     *
     * @param traceId The trace ID to be decided on, can be ignored
     */
    @Override
    public boolean isSampled(long traceId) {
        return traceId % 3 == 0;
    }
}