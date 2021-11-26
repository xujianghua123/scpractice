package com.mq.rocket.producer.base;

import com.mq.rocket.config.ProducerClient;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * 异步生产
 */
public class AsyncProducer {

    @Autowired
    private DefaultMQProducer mqProducer;

    public static void main(String[] args) throws Exception{

        DefaultMQProducer producer = new ProducerClient().mqProducer();
        // 启动producer
        producer.start();
        for (int i = 0; i < 5; i++) {
            //创建消息对象，指定主体topic、tag和消息内容
            Message msg = new Message("TopicTest" ,"Tag_async" ,("async test " + i).getBytes());
            //发送异步消息
           producer.send(msg, new SendCallback() {
               /**
                * 发送成功回调函数
                * @param sendResult
                */
               @Override
               public void onSuccess(SendResult sendResult) {
                   System.out.println("发送结果：" + sendResult);
               }

               /**
                * 发送失败回调函数
                * @param e
                */
               @Override
               public void onException(Throwable e) {
                   System.out.println("发送异常：" + e);
               }
           });

            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("#######################################");
        //关闭生产者
        producer.shutdown();
    }
}
