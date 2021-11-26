package com.mq.rocket.producer.batch;

import com.mq.rocket.config.ProducerClient;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;

public class BatchProducer {

    public static void main(String[] args) throws Exception{

        DefaultMQProducer producer = new ProducerClient().mqProducer();
        // 启动producer
        producer.start();
        List<Message> msgs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("BatchTopic","Tag_batch",("batch_" + i).getBytes());
            msgs.add(msg);
        }
        SendResult sendResult = producer.send(msgs);
        System.out.printf("%s%n", sendResult);
        producer.shutdown();
    }
}
