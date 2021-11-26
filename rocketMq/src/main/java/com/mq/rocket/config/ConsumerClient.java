package com.mq.rocket.config;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerClient {

    @Bean
    public DefaultMQPushConsumer defaultMQPushConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myGroup");
        consumer.setNamesrvAddr("42.192.6.87:9876");
        return consumer;
    }

    @Bean
    public DefaultMQPushConsumer TrMQPushConsumer(){
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("myGroup");
        consumer.setNamesrvAddr("42.192.6.87:9876");
        return consumer;
    }
}
