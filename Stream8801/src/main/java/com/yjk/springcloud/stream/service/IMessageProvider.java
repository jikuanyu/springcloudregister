package com.yjk.springcloud.stream.service;

/**
 * @author Administrator
 */
public interface IMessageProvider {
    /**
     * 发送消息
     * @return
     */
    public String send();
}
