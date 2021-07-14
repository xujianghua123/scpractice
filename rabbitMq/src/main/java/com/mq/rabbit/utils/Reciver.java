package com.mq.rabbit.utils;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author : xujianghua
 * @description : TODO
 * @date : 2021/6/26 10:21
 */
@Component
public class Reciver extends DefaultConsumer {

    private Channel channel;

    public Reciver(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body);
        System.out.println("TagId:" + envelope.getDeliveryTag() + "\t接收到的消息：" + message);
        channel.basicAck(envelope.getDeliveryTag(),false);
    }
}
