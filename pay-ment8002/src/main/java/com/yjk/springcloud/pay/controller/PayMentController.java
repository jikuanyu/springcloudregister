package com.yjk.springcloud.pay.controller;


import com.yjk.springcloud.entity.CommonResult;
import com.yjk.springcloud.entity.PayMent;
import com.yjk.springcloud.pay.service.PlayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PayMentController {

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PlayMentService playMentService;
    @RequestMapping("/pays/create")
    public CommonResult create(@RequestBody PayMent payMent) {
        playMentService.create(payMent);
        return CommonResult.valueOf(payMent);

    }
    @RequestMapping("/pays/get/{id}")
    public CommonResult getPayMentById(@PathVariable("id") Long id) {
      log.info("id="+id);
        return CommonResult.valueOf(playMentService.getPayMentById(id),"server.port="+serverPort);
    }


}
