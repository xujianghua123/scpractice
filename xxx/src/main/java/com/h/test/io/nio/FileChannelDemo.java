package com.h.test.io.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) throws Exception {

        // 创建fileChannel
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\18236\\Desktop\\log3.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读取数据到buffer中
        int count  = channel.read(buffer);
        while (count != -1){
            System.out.println("读取了：" + count);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            count = channel.read(buffer);
        }
        accessFile.close();
        System.out.println();
        System.out.println("读取数据结束！");

    }
}
