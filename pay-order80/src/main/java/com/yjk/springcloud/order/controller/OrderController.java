package com.yjk.springcloud.order.controller;


import com.yjk.springcloud.springcloud.entity.CommonResult;
import com.yjk.springcloud.springcloud.entity.PayMent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001/";
    public static final String  PAYMENT_URL="http://PAY-MENT/";
    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/pays/create")
    public CommonResult create(PayMent payMent) {

       return restTemplate.postForObject(PAYMENT_URL+"pays/create",payMent,CommonResult.class);
    }
    @RequestMapping("/consumer/pays/get/{id}")
    public CommonResult getPayMentById(@PathVariable("id") Long id) {
        log.info("id="+id);
       return  restTemplate.getForObject(PAYMENT_URL+"pays/get/"+id,CommonResult.class);
    }


}
