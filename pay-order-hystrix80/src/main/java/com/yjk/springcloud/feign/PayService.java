package com.yjk.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: yujikuan
 * @Description:
 */
@FeignClient(name="hystrix-pay-ment")
public interface PayService {

    @RequestMapping("/pays/ok/{id}")
    public String sayOk(@PathVariable("id") String id);

    @RequestMapping("/pays/timeout/{id}")
    public String sayTimeout(@PathVariable("id") String id);
}
