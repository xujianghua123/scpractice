package com.h.test.io.nio.demo;

import javafx.scene.control.TableRow;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {

    public static void main(String[] args) throws Exception{

        // 创建buffer
        String msg = "socketChannel test!";
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());

        // 打开channel
        ServerSocketChannel ssc = ServerSocketChannel.open();

        // 绑定端口
        ssc.socket().bind(new InetSocketAddress(8888));

        // 设置为非阻塞
        ssc.configureBlocking(false);

        while (true){
            System.out.println("waiting for connections！");
            SocketChannel accept = ssc.accept();
            // 没有连接接入
            if(accept == null){
                System.out.println("null");
                Thread.sleep(2000);
            }
            // 有连接接入
            else{
                System.out.println("incoming connection from: " + accept.socket().getRemoteSocketAddress());
                buffer.rewind();
                accept.write(buffer);
                accept.close();
            }
        }
    }
}
