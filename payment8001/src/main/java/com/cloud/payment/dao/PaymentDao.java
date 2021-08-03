package com.cloud.payment.dao;

import com.cloud.common.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface PaymentDao {

    Integer create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
