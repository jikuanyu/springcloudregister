package com.yjk.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private Integer status;
    private String message;
    private T data;

    public static<T> CommonResult<T> valueOf(T data)
    {
        return new CommonResult<T>(200,"",data);
    }
    public static<T> CommonResult<T> valueOf(T data,String message)
    {
        return new CommonResult<T>(200,message,data);
    }
}
