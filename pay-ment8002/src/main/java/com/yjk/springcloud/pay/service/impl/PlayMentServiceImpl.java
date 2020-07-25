package com.yjk.springcloud.pay.service.impl;

import com.yjk.springcloud.entity.PayMent;
import com.yjk.springcloud.pay.dao.PayMentDao;

import com.yjk.springcloud.pay.service.PlayMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayMentServiceImpl implements PlayMentService {
    @Autowired
    private PayMentDao payMentDao;

    public void create(PayMent payMent) {

        payMentDao.create(payMent);
    }

    public PayMent getPayMentById(Long id) {
        return payMentDao.getPayMentById(id);
    }
}
