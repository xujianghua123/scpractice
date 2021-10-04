package com.h.test.io.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class DatagramChannelDemo {

    @Test
    public void sendDatagram() throws Exception{
        // 打开channel
        DatagramChannel sendChannel = DatagramChannel.open();
        // 设置地址和端口
        InetSocketAddress sendAddress = new InetSocketAddress("127.0.0.1", 9999);

        // 发送
        while (true){
            ByteBuffer buffer = ByteBuffer.wrap("datagram".getBytes("UTF-8"));
            int send = sendChannel.send(buffer, sendAddress);
            System.out.println("已完成发送！");
            Thread.sleep(1000);
        }
    }

    @Test
    public void receiveDatagram() throws Exception{

        // 打开channel
        DatagramChannel receiveChannel = DatagramChannel.open();

        // 设置端口
        InetSocketAddress receiveAddress = new InetSocketAddress(9999);
        receiveChannel.bind(receiveAddress);

        ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

        // 接收
        while (true){
            receiveBuffer.clear();
            SocketAddress receive = receiveChannel.receive(receiveBuffer);
            receiveBuffer.flip();
            System.out.println(receiveAddress.toString());
            System.out.println(Charset.forName("UTF-8").decode(receiveBuffer));
        }
    }
}
