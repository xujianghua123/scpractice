package com.h.test.io.nio;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

// channel之间的数据传输
public class FileChannelDemo3 {


    public static void main(String[] args) throws Exception{

        RandomAccessFile accessFile1 = new RandomAccessFile("C:\\Users\\18236\\Desktop\\log2.txt", "rw");
        FileChannel channel1 = accessFile1.getChannel();

        RandomAccessFile accessFile2 = new RandomAccessFile("C:\\Users\\18236\\Desktop\\log3.txt", "rw");
        FileChannel channel2 = accessFile2.getChannel();

//        channel1.transferTo(0,channel1.size(),channel2);

        channel2.transferFrom(channel1,0,channel1.size());
        channel1.close();
        channel2.close();
        System.out.println("over!");
    }
}
