package com.yjk.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PayMentMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8005.class,args);
    }
}
