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


public String sayOk(String id){

    return Thread.currentThread()+",id="+id+",ok";
}
@HystrixCommand(fallbackMethod = "sayTimeoutFallbackMethod",commandProperties = {
        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "2000")

})
public String sayTimeout(String id)
{
    int num=3;
    try {
        TimeUnit.SECONDS.sleep(num);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return Thread.currentThread()+",id="+id+"status= timeout(秒）= "+num;


  /* int a=10/0;
   return "ooo error";*/
}

    public String sayTimeoutFallbackMethod(String id)
    {

        return Thread.currentThread()+",id="+id+",系统异常稍后重试。xx";
    }
}
