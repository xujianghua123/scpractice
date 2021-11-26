package com.mq.rocket.producer.batch;

import com.mq.rocket.config.ConsumerClient;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class BatchConsumer {

    public static void main(String[] args) throws Exception {
        // 创建消费者-绑定mq地址和group
        DefaultMQPushConsumer consumer = new ConsumerClient().defaultMQPushConsumer();
        //订阅主题topic和tag
        consumer.subscribe("BatchTopic","*");
        // 设置消费模式（默认：负载均衡 | 轮循）
        consumer.setMessageModel(MessageModel.CLUSTERING);
        //设置回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            //接收消息内容
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg:list) {
                    System.out.println("消息内容：" + new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
    }
}
