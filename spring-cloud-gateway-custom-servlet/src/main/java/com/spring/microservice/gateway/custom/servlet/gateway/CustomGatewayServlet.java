package com.spring.microservice.gateway.custom.servlet.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * @Author ZWen
 * @Date 2019/3/11 9:02 PM
 * @Version 1.0
 **/
@WebServlet(name = "gateway", urlPatterns = "/gateway/*")
public class CustomGatewayServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(CustomGatewayServlet.class);

    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    public CustomGatewayServlet(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("accept request uri : {}", req.getRequestURI());

        String[] strings = StringUtils.split(req.getPathInfo().substring(1), "/");
        if (strings == null) {
            return;
        }
        List<ServiceInstance> instances = discoveryClient.getInstances(strings[0]);
        ServiceInstance serviceInstance = chooseInstance(instances);

        String url = buildUrl(serviceInstance, strings[1], req);
        Object result = restTemplate.getForObject(url, String.class);

        logger.info("response result : {}", result);

        resp.getWriter().write(String.valueOf(result));
    }

    private String buildUrl(ServiceInstance serviceInstance, String uri, HttpServletRequest req) {
        StringBuilder builder = new StringBuilder("http://");
        builder.append(serviceInstance.getHost())
                .append(":")
                .append(serviceInstance.getPort())
                .append("/")
                .append(uri);
        if (StringUtils.hasText(req.getQueryString())) {
            builder.append("?").append(req.getQueryString());
        }
        return builder.toString();
    }

    private ServiceInstance chooseInstance(List<ServiceInstance> instances) {
        if (instances == null) {
            return null;
        }
        return instances.get(new Random().nextInt(instances.size()));
    }
}