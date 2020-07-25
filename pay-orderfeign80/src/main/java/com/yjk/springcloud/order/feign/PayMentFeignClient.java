package com.yjk.springcloud.order.feign;

import com.yjk.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yujikuan
 * @Description:
 */
@FeignClient("pay-ment")
public interface PayMentFeignClient {
    @RequestMapping("/pays/get/{id}")
    public CommonResult getPayMentById(@PathVariable("id") Long id);

    @RequestMapping("/pays/timeout")
    public String timeout() throws InterruptedException;
}
