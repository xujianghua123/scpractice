package com.h.test.t;


import lombok.Data;

public class OrderService {

    public void transfer(Account account,double addMoney){
        synchronized(this){
            account.setBlance(addMoney + addMoney);
        }
    }

}

@Data
class Account {
    private long id; // 账户id
    private double blance; // 账户余额

    // 省略构造方法和getter/setter
}