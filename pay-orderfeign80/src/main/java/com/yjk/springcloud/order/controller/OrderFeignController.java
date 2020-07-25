package com.yjk.springcloud.order.controller;

import com.yjk.springcloud.entity.CommonResult;
import com.yjk.springcloud.order.feign.PayMentFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: yujikuan
 * @Description:
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PayMentFeignClient payMentFeignClient;

    @RequestMapping("/feign/pays/get/{id}")
    public CommonResult getPayMentById(@PathVariable("id") Long id) {

        return payMentFeignClient.getPayMentById(id);
    }

    @RequestMapping("/feign/pays/timeout")
    public String timeout() throws InterruptedException{
        return payMentFeignClient.timeout();
    }
}
