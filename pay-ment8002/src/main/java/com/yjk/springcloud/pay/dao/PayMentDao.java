package com.yjk.springcloud.pay.dao;


import com.yjk.springcloud.entity.PayMent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayMentDao {
    public void create(PayMent payMent);
    public PayMent getPayMentById(@Param("id") Long id);
}
