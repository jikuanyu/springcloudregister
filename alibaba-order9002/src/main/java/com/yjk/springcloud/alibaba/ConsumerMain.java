package com.yjk.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: yujikuan
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain.class, args);
    }
}
