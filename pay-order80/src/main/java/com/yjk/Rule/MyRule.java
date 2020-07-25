package com.yjk.Rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author: yujikuan
 * @Description: 比如这里的随机负载
 *  首先这个自定义配置类不能放到@ComponentScan所能扫描的当前包以及子包下，否则我们自定义的这个配置类就会所有的Ribbon客户端所共享，达不到特殊化定制的目的了。
 */
@Configuration
public class MyRule {
    @Bean
    public IRule getRule(){
      return   new RandomRule();
       // return new RoundRobinRule();
    }
}
