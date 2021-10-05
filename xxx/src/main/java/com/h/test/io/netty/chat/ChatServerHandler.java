package com.h.test.io.netty.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatServerHandler extends SimpleChannelInboundHandler<String> {

    //GlobalEventExecutor.INSTANCE 是全局的事件执行器，是一个单例
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //表示 channel 处于就绪状态, 提示上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();

        // 将上线信息广播给当前在线用户
        channelGroup.writeAndFlush("客户端" + channel.remoteAddress() + "上线了！" + sdf.format(new Date()));

        // 将用户通道加入到通道组
        channelGroup.add(channel);

        System.out.println(ctx.channel().remoteAddress() + " 上线了" + "\n");
    }

    //表示 channel 处于不活动状态, 提示离线了
    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();

        // 将离线消息广播给当前在线用户
        channelGroup.writeAndFlush("客户端" + channel.remoteAddress() + "下线了！");

        System.out.println(ctx.channel().remoteAddress() + " 上线了" + "\n");
        System.out.println("channelGroup size=" + channelGroup.size());
    }

    // 读取数据
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg){
        Channel channel = ctx.channel();
        channelGroup.forEach(ch->{
            if(ch == channel){
                ch.writeAndFlush("【自己】： " + msg);
            }else {
                ch.writeAndFlush("【客户端" + ch.remoteAddress() + "】： " + msg);
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        //关闭通道
        ctx.close();
    }
}
