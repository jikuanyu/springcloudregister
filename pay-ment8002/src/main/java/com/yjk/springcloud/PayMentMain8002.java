package com.yjk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// @EnableEurekaClient
@EnableDiscoveryClient
public class PayMentMain8002 {

    public  static  void main(String[] args){
        SpringApplication.run(PayMentMain8002.class,args);
    }
}
