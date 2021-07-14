package com.mq.rabbit.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author : xujianghua
 * @description : TODO
 * @date : 2021/6/24 23:01
 */
public class MqConnectionUtil {

    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    static{
        connectionFactory.setHost("192.168.0.106");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("xjh");
        connectionFactory.setPassword("xjh");
        connectionFactory.setVirtualHost("/cloud");
    }

    public static Connection getMqConnection() {

        Connection conn = null;
        try {
            conn = connectionFactory.newConnection();
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
