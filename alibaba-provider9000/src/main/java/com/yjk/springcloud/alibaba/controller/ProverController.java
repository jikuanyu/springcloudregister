package com.yjk.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yujikuan
 * @Description:dd
 */
@RestController
public class ProverController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("getProviderPort")
    public String getServerPort()
    {
        return serverPort;
    }
}
