package com.yjk.springcloud.feign;

import org.springframework.stereotype.Component;

/**
 * @author: yujikuan
 * @Description:
 */
@Component
public class PayServiceFallBack implements PayService {

    public String sayOk(String id) {

        return "sayOK 提供方异常";
    }

    public String sayTimeout(String id) {
    //throw  new RuntimeException("ayTimeout 提供方异常");
        return "sayTimeout 提供方异常 ";
    }
}
