package com.h.test.io.netty.server;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class ChatServer {

    public void startServer() throws Exception{
        // 创建selector
        Selector selector = Selector.open();

        // 创建channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 绑定监听端口
        channel.bind(new InetSocketAddress("127.0.0.1",8080));
        channel.configureBlocking(false);

        // 将channel注册到selector上
        channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功......");
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
                // accept状态
                if(key.isAcceptable()){
                    acceptOperator(channel,selector);
                }
                // read状态
                if(key.isReadable()){
                    readOperator(selector,key);
                }
            }
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
            // 广播给其他客户端
            System.out.println(message);
            castOtherClient(message,selector,socketChannel);
        }
    }

    // 广播给其他客户端
    private void castOtherClient(String message, Selector selector, SocketChannel socketChannel) throws Exception{

        // 获取已接入的channel
        Set<SelectionKey> selectionKeys = selector.keys();
        for(SelectionKey key:selectionKeys){
            Channel channel = key.channel();
            // 无需给自己发送
            if(channel instanceof SocketChannel && channel != socketChannel) {
                // 循环广播想要通知的channel
                ((SocketChannel)channel).write(Charset.forName("UTF-8").encode(message));
            }
        }
    }

    // 处理接入状态操作
    private void acceptOperator(ServerSocketChannel channel, Selector selector) throws Exception{
        // 创建socketChannel
        SocketChannel accept = channel.accept();
        // 设置为非阻塞模式
        accept.configureBlocking(false);
        // 注册到选择器上,设置为可读状态
        accept.register(selector,SelectionKey.OP_READ);
        // 客户端回复消息
        accept.write(Charset.forName("UTF-8").encode("欢迎进入聊天室，请注意隐私安全！"));
    }

    public static void main(String[] args) {
        try {
            new ChatServer().startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
