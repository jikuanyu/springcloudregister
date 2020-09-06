package com.yjk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: yujikuan
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientPayConfigMain3501 {
    public static void main(String[] args) {
        SpringApplication.run(ClientPayConfigMain3501.class,args);
    }
}
