package com.yjk.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: yujikuan
 * @Description:
 */
@RestController
@RefreshScope
public class CunsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${provider.url}")
    private String url;

    @RequestMapping("getProviderPort")
    public String getProviderPort() {

        return restTemplate.getForObject(url, String.class);

    }
    @Value("${config.info}")
    private String info;
    @RequestMapping("getInfo")
    public String getInfo()
    {
        return info;
    }


}
