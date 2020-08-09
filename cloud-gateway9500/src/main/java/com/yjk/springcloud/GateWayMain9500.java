package com.yjk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author  yujikuan
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9500 {
    public static void main(String[] args) {

        SpringApplication.run(GateWayMain9500.class,args);
    }
}
