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
public class ProviderMain2 {
    public static void main(String[] args) {

        SpringApplication.run(ProviderMain2.class,args);
    }
}
