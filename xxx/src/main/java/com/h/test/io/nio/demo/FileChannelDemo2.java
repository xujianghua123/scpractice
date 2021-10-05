package com.h.test.io.nio.demo;


import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo2 {

    public static void main(String[] args) throws Exception{

        // 打开channel
        RandomAccessFile accessFile = new RandomAccessFile("C:\\Users\\18236\\Desktop\\log2.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        String data = "this is fileChannel write test!";

        buffer.clear();
        buffer.put(data.getBytes());
        buffer.flip();

        while (buffer.hasRemaining()){
            channel.write(buffer);
        }

        channel.close();

        System.out.println("写入fileChannel成功！");

    }
}
