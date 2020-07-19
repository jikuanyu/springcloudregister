package com.yjk.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 */
@RestController
public class ConsulOrderController {

    public static final String url = "http://pay-ment-consul";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/pays/consul")
    public String paytest() {

        String result = restTemplate.getForObject(url+"/pays/consul", String.class);
        return "client="+result;
    }


}
