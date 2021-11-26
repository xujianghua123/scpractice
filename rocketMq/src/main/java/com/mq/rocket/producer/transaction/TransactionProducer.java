package com.mq.rocket.producer.transaction;

import com.mq.rocket.config.ProducerClient;
import org.apache.commons.lang.StringUtils;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

public class TransactionProducer {

    public static void main(String[] args) throws Exception{
        TransactionMQProducer producer = new ProducerClient().trMqProducer();
        setTransactionListener(producer);

        String[] tags = {"tagA","tagB","tagC"};
        // 启动producer
        producer.start();
        for (int i = 0; i < 3; i++) {
            Message msg = new Message("TrTopic",tags[i],("transaction message " + i).getBytes());
            SendResult sendResult = producer.sendMessageInTransaction(msg,null);
            System.out.printf("%s%n", tags[i % tags.length]);
        }
        producer.shutdown();
    }

    /**
     * 设置事务监听器
     *
     * @param producer
     */
    private static void setTransactionListener(TransactionMQProducer producer){

        producer.setTransactionListener(new TransactionListener() {
            /**
             * 在该方法中执行本地事务
             * @param msg
             * @param o
             * @return
             */
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object o) {

                if(StringUtils.equals("tagA",msg.getTags())){
                    return LocalTransactionState.COMMIT_MESSAGE;
                }else if(StringUtils.equals("tagB",msg.getTags())){
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }else if(StringUtils.equals("tagC",msg.getTags())){
                    return LocalTransactionState.UNKNOW;
                }
                return LocalTransactionState.UNKNOW;
            }

            /**
             * 进行消息事务状态回查
             * @param messageExt
             * @return
             */
            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                System.out.println("消息的tags：" + messageExt.getTags());
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
    }
}
