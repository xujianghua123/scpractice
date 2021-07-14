package com.mq.rabbit.route;

import com.mq.rabbit.utils.MqConnectionUtil;
import com.mq.rabbit.utils.RabbitConstant;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author : xujianghua
 * @description : TODO
 * @date : 2021/6/26 10:32
 */
public class Sina {

    public static void main(String[] args) throws Exception{

        Connection conn = MqConnectionUtil.getMqConnection();

        Channel channel = conn.createChannel();

        channel.queueDeclare(RabbitConstant.QUEUE_SINA,false, false, false, null);

        // 绑定交换机 队列名，交换机名，路由key
        channel.queueBind(RabbitConstant.QUEUE_SINA,RabbitConstant.EXCHANGE_WEATHER,"china.henan.zhengzhou.20210627");
        channel.queueBind(RabbitConstant.QUEUE_SINA,RabbitConstant.EXCHANGE_WEATHER,"us.NewYork.20210628");
        channel.basicQos(1);
        //从MQ服务器中获取数据
        channel.basicConsume(RabbitConstant.QUEUE_SINA, false, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws
                    IOException {
                String message = new String(body);
                System.out.println("新浪天气接收到的消息：" + message);
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
          }
        );

    }
}
