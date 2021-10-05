package com.h.test.io.nio.chatRoom.client;

import javax.print.DocFlavor;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class ChatClient {

    public void startClient(String name) throws Exception{
        // 连接服务器
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));

        // 接收服务器返回的信息
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        new Thread(() -> {
                receiveMessage(selector);
        }).start();

        // 向服务器发送信息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            if(msg.length() > 0){
                channel.write(Charset.forName("UTF-8").encode( name + " : " + msg));
            }
        }
    }

    public void receiveMessage(Selector selector){
        try {
            // 循环等待有新连接接入
            for (; ;) {
                // 获取channel数量
                if(selector.select() == 0) continue;

                // 获取可用channel集合
                Set<SelectionKey> selectionKeys = selector.selectedKeys();

                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    // read状态
                    if(key.isReadable()){
                        readOperator(selector,key);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 处理可读状态操作
    private void readOperator(Selector selector, SelectionKey key) throws Exception {
        // 从SelectionKey获取已就绪的通道
        SocketChannel socketChannel = (SocketChannel)key.channel();
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 循环读取客户端信息
        int readLength = socketChannel.read(buffer);

        String message = "";
        if (readLength > 0){
            // 切换读模式
            buffer.flip();

            // 读取内容
            message += Charset.forName("UTF-8").decode(buffer);
        }

        // 将channel注册到选择器上，监听可读状态
        socketChannel.register(selector,SelectionKey.OP_READ);
        // 把客户端信息广播到其他客户端
        if (message.length() > 0){
            // 打印消息
            System.out.println(message);
        }
    }
}
