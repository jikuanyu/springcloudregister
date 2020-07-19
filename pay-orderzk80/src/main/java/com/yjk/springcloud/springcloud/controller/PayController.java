package com.yjk.springcloud.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PayController {

    public static final String url = "http://pay-ment-zk-service";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/pays/paytest")
    public String paytest() {

        String result = restTemplate.getForObject(url+"/pays/paytest", String.class);
        return result;
    }
}
