package com.yjk.springcloud.pay.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PayMentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("pays/paytest")
    public String payTest() {
        return "zk serverPort="+serverPort+"试试试试等待,uuid ="+ UUID.randomUUID().toString();
    }

}
