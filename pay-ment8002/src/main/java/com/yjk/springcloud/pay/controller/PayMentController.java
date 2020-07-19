package com.yjk.springcloud.pay.controller;


import com.yjk.springcloud.springcloud.entity.CommonResult;
import com.yjk.springcloud.springcloud.entity.PayMent;
import com.yjk.springcloud.pay.service.PlayMentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class PayMentController {

    @Value("${server.port}")
    private String serverPort;
    @Autowired
    private PlayMentService playMentService;
    @Autowired
    private DiscoveryClient discoveryClient;
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
  @RequestMapping("/pays/getserviceinfo")
   public Object getServiceInfo(){

      Map<String,List<ServiceInstance>> map=new HashMap<String, List<ServiceInstance>>();
       for (String service : discoveryClient.getServices()) {
           log.info(service);
           List<ServiceInstance> instances = discoveryClient.getInstances(service);
           for (ServiceInstance instance : instances) {
               log.info(instance.toString());
           }
           map.put(service,instances);
       }
       return map;
   }

}
