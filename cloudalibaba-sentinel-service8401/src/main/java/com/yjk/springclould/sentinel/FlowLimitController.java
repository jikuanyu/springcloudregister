package com.yjk.springclould.sentinel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author: yujikuan
 * @Description:
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
      TimeUnit.MILLISECONDS.sleep(500L);
        return "----testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName()+"/t testB");
        return "----testB";
    }
    @GetMapping("/testD")
    public String testD()  {
        try {
            TimeUnit.MILLISECONDS.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----testD";
    }
  int i=0;
    @GetMapping("/testE")
    public String testE()  {
      i++;
    if(i%2==0){
        throw new RuntimeException("i="+i);
    }
        return "----testE";
    }
}
