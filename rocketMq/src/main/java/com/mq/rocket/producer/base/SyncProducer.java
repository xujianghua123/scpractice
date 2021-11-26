package com.mq.rocket.producer.base;

import com.mq.rocket.config.ProducerClient;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 同步生产者
 */
@Component
public class SyncProducer {

    @Autowired
    private DefaultMQProducer mqProducer;

    public static void main(String[] args) throws Exception{

        DefaultMQProducer producer = new ProducerClient().mqProducer();
        // 启动producer
        producer.start();
        for (int i = 0; i < 10; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    "Tag_sync" /* Tag */,
                    ("sync Test" + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}
