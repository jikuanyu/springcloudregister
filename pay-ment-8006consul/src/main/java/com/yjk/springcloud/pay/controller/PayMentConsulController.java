package com.yjk.springcloud.pay.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PayMentConsulController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("pays/consul")
    public String payTest() {
        return "consul serverPort="+serverPort+",uuid ="+ UUID.randomUUID().toString();
    }
}
