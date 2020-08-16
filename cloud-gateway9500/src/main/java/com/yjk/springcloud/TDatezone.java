package com.yjk.springcloud;

import java.time.ZonedDateTime;

/**
 * @author: yujikuan
 * @Description:
 */
public class TDatezone {
    public static void main(String[] args) {


        ZonedDateTime zonedDateTimeDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTimeDateTime.toString());

    }

}
