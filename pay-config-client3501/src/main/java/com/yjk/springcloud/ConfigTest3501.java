package com.yjk.springcloud;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yujikuan
 * @Description:
 */
@RestController
@RefreshScope

public class ConfigTest3501 {
    @Value("${config.info}")
    private String info;
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/getInfo")
    public String getInfo(){

        return info+"\n"+serverPort;
    }

}
