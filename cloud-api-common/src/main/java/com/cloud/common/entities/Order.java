package com.cloud.common.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order implements Serializable {

    private Long id;

    private String orderNo;
    
    private BigDecimal price;

    private Integer quantity;

    private Date orderTime;

    public Order(Long id, String orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }
}
