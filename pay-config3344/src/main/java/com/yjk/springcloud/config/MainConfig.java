package com.yjk.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author: yujikuan
 * @Description:
 */
@SpringBootApplication
@EnableConfigServer
public class MainConfig {
    public static void main(String[] args) {
        SpringApplication.run(MainConfig.class,args);
    }
}
