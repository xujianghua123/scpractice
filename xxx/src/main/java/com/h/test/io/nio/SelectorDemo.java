package com.h.test.io.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo {

    public static void main(String[] args) throws Exception {
        // 创建selector
        Selector selector = Selector.open();
        // 创建channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        // channel必须为非阻塞模式
        channel.configureBlocking(false);
        channel.bind(new InetSocketAddress(99999));
        // 将channel注册到selector上
        channel.register(selector, SelectionKey.OP_ACCEPT);

        // 查询已就绪的channel集合
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()){
            SelectionKey key = iterator.next();
            // 判断key就绪状态
            if(key.isAcceptable()){

            }else if(key.isConnectable()){

            }else if(key.isReadable()){

            }else if(key.isWritable()){

            }else{
                // 有效的
            }
            iterator.remove();
        }
    }
}
