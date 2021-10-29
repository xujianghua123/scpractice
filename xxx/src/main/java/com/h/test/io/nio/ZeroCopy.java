package com.h.test.io.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ZeroCopy {

    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\18236\\Desktop\\log.txt");
        // 内核空间使用mmap copy
        RandomAccessFile accessFile = new RandomAccessFile(file, "rw");
        MappedByteBuffer map = accessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        map.put("mmap content".getBytes());
        accessFile.close();

        // 硬盘空间使用transfer
        try (FileInputStream fis = new FileInputStream(file)){
            FileChannel fisChannel = fis.getChannel();
            FileOutputStream fos = new FileOutputStream("C:\\Users\\18236\\Desktop\\log_copy.txt");
            FileChannel fosChannel = fos.getChannel();
            // 由输入流写入输出流  核心从一个管道连接到另一个管道
            fisChannel.transferTo(0,file.length(),fosChannel);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
