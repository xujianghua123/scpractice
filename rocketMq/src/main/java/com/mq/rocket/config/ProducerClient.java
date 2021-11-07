package com.mq.rocket.config;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerClient {

    @Bean
    public DefaultMQProducer mqProducer(){
        DefaultMQProducer producer = new DefaultMQProducer("myGroup");
        producer.setNamesrvAddr("42.192.6.87:9876");
        return producer;
    }
}
