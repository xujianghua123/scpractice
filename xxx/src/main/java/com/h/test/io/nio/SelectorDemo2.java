package com.h.test.io.nio;

import lombok.SneakyThrows;
import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo2 {

    @Test
    public void clientTest() throws Exception{
        // 获取通道
        SocketChannel channel = SocketChannel.open();
        // 绑定端口
        channel.bind(new InetSocketAddress("127.0.0.1",9999));
        // 切换至非阻塞模式
        channel.configureBlocking(false);

        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String msg = "this is client!";
        buffer.put(msg.getBytes());
        buffer.flip();

        // 写入通道
        channel.write(buffer);

        // 关闭
        channel.close();


    }

    @Test
    public void serverTest() throws Exception{
        // 创建channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 切换至非阻塞模式
        channel.configureBlocking(false);

        channel.bind(new InetSocketAddress(9999));
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 获取selector
        Selector selector = Selector.open();

        // 通道注册到选择器
        channel.register(selector, SelectionKey.OP_ACCEPT);

        // 选择器轮询监听
        while (selector.select() > 0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                // 判断key就绪状态
                if(key.isAcceptable()){

                    // 获取连接
                    SocketChannel accept = channel.accept();
                    // 设置为非阻塞模式
                    accept.configureBlocking(false);
                    // 注册
                    accept.register(selector,SelectionKey.OP_READ);

                }else if(key.isConnectable()){

                }else if(key.isReadable()){

                    System.out.println("readAble!");
                }else if(key.isWritable()){

                }else{
                    // 有效的
                }
                iterator.remove();
            }
        }


    }

}
