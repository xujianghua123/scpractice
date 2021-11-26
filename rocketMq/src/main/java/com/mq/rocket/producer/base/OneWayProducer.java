package com.mq.rocket.producer.base;

import com.mq.rocket.config.ProducerClient;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * 单向发送
 */
public class OneWayProducer {

    @Autowired
    private DefaultMQProducer mqProducer;

    public static void main(String[] args) throws Exception{

        DefaultMQProducer producer = new ProducerClient().mqProducer();
        // 启动producer
        producer.start();
        for (int i = 0; i < 3; i++) {
            Message msg = new Message("TopicTest", "Tag_oneWay" ,("oneWay producer " + i).getBytes());
            producer.sendOneway(msg);
            TimeUnit.SECONDS.sleep(5);
        }
        producer.shutdown();
    }
}
