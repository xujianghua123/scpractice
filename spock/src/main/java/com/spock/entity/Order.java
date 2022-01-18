package com.spock.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/17 17:32
 */
@Data
public class Order {

    private Long orderId;

    private BigDecimal orderAmt;

    private String goodsInfo;
}
