package com.yjk.springcloud.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author: yujikuan
 * @Description:
 */
@Service
public class PayMentService {


    public String sayOk(String id) {

        return Thread.currentThread() + ",id=" + id + ",ok";
    }

    @HystrixCommand(fallbackMethod = "sayTimeoutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")

    })
    public String sayTimeout(String id) {
        int num = 1;
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread() + ",id=" + id + "status= timeout(秒）= " + num;


  /* int a=10/0;
   return "ooo error";*/
    }

    public String sayTimeoutFallbackMethod(String id) {

        return Thread.currentThread() + ",id=" + id + ",系统异常稍后重试。xx";
    }
    @HystrixCommand(fallbackMethod = "testFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),

            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")

    })

    public String test(int id) {
     if(id<0){
         throw  new RuntimeException("id="+id+",必须为正数");
     }
     return Thread.currentThread() + ",id=" + id;
    }
    public String testFallbackMethod(int id)
    {
        return "错误,id="+id+"必须为正数";
    }
}