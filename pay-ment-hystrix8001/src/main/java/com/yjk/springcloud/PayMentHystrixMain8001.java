package com.yjk.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.Servlet;

/**
 * @author: yujikuan
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PayMentHystrixMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(PayMentHystrixMain8001.class, args);
    }

 @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean servletServletRegistrationBean = new ServletRegistrationBean(streamServlet);
     servletServletRegistrationBean.setLoadOnStartup(1);
     servletServletRegistrationBean.addUrlMappings("/hystrix.stream");
     servletServletRegistrationBean.setName("HystrixMetricsStreamServlet");
        return servletServletRegistrationBean;
    }
}