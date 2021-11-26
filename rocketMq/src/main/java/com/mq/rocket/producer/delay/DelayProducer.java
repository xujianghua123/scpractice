package com.mq.rocket.producer.delay;

import com.mq.rocket.config.ProducerClient;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class DelayProducer {

    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new ProducerClient().mqProducer();
        // 启动producer
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message msg = new Message("DelayTopic",
                    "Tag_delay",
                    ("delay message " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            // 设置延时级别 (1s - 2h 共18个级别)
            msg.setDelayTimeLevel(2);
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        producer.shutdown();
    }
}
