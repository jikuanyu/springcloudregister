package com.yjk.springcloud.hystrix;

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
public class PayMentConroller {
    @Resource
    private PayMentService payMentService;

    @RequestMapping("/pays/ok/{id}")
    public String sayOk(@PathVariable("id") String id) {

        String s = payMentService.sayOk(id);
        log.info(s);
        return s;


    }

    @RequestMapping("/pays/timeout/{id}")
    public String sayTimeout(@PathVariable("id") String id) {

        String s = payMentService.sayTimeout(id);
        log.info(s);
        return s;

    }
    @RequestMapping("/pays/test/{id}")
    public String test(@PathVariable("id") int id){

        return payMentService.test(id);
    }


}
