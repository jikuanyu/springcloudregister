package com.yjk.springcloud.pay.service;

import com.yjk.springcloud.entity.PayMent;


public interface PlayMentService {
    public void create(PayMent payMent);
    public PayMent getPayMentById(Long id);
}
