package com.h.test.io.netty.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChatServer {

    public static void main(String[] args) {

        // 创建两个线程组bossGroup和workerGroup, 含有的子线程NioEventLoop的个数默认为cpu核数的两倍
        // bossGroup 默认只处理连接线程
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // workerGroup负责处理读写线程
        NioEventLoopGroup workerGroup = new NioEventLoopGroup(8);

        try {
            // 创建服务端启动实现
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) // 设置NioServerSocketChannel为通道实现
                    .option(ChannelOption.SO_BACKLOG,1024) // 初始化服务器连接队列大小
                    .childHandler(new ChannelInitializer<SocketChannel>(){ // 创建对象初始化参数
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();

                            // 加入解码handler
                            pipeline.addLast("decode",new StringDecoder());

                            // 加入编码handler
                            pipeline.addLast("encode",new StringEncoder());

                            // 加入自定义handler
                            pipeline.addLast(new ChatServerHandler());
                        }
                    });

            System.out.println("聊天室启动成功......");

            // 同步绑定端口
            ChannelFuture future = bootstrap.bind(9000).sync();

            // 关闭通道
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
