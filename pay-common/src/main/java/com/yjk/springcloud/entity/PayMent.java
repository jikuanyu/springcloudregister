package com.yjk.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PayMent implements  java.io.Serializable{
    @EqualsAndHashCode.Include
    private Long id;
    private String serial;
}
