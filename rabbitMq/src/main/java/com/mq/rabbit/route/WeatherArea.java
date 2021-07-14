package com.mq.rabbit.route;

import com.mq.rabbit.utils.MqConnectionUtil;
import com.mq.rabbit.utils.RabbitConstant;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : xujianghua
 * @description : TODO
 * @date : 2021/6/26 10:37
 */
public class WeatherArea {

    public static void main(String[] args) throws Exception{
        //获取TCP长连接
        Connection conn = MqConnectionUtil.getMqConnection();
        //创建通信“通道”，相当于TCP中的虚拟连接
        Channel channel = conn.createChannel();

        Map<String, String> areaMap = new LinkedHashMap<>();
        areaMap.put("china.henan.zhengzhou.20210627","河南郑州20210627日天气状况良好！");
        areaMap.put("china.henan.xinyang.20210627","河南信阳20210627日天气状况良好！");
        areaMap.put("china.shanghai.putuo.20210627","上海普陀20210627日天气状况良好！");
        areaMap.put("china.beijign.haidian.20210627","北京海淀20210627日天气状况良好！");
        areaMap.put("us.NewYork.20210628","美国纽约20210628日天气状况良好！");

        areaMap.entrySet().forEach(item ->{
            item.getKey();
            try {
                // 交换机名，routing key，，队列信息
                channel.basicPublish(RabbitConstant.EXCHANGE_WEATHER,item.getKey(),null,item.getValue().getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        channel.close();
        conn.close();
        System.out.println("===消息发送成功===");
    }
}
