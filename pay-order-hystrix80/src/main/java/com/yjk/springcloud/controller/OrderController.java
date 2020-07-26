package com.yjk.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.yjk.springcloud.feign.PayService;
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
public class OrderController {
    @Resource
    private PayService payService;
    @RequestMapping("/pays/ok/{id}")
    public String sayOk(@PathVariable String id){
        return payService.sayOk(id);

    }


    @RequestMapping("/pays/timeout/{id}")
    @HystrixCommand(fallbackMethod = "sayTimeoutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public String sayTimeout(@PathVariable String id){
        return payService.sayTimeout(id);
       //return payService.sayOk(id);
    }

    public String sayTimeoutFallbackMethod(String id)
    {

        return Thread.currentThread()+",id="+id+",客户端熔断你,系统异常稍后重试。ddxx";
    }


}
