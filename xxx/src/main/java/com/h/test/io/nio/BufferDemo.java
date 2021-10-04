package com.h.test.io.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class BufferDemo {

    @Test
    public void buffer01(){
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i = 0; i < buffer.capacity() ; i++) {
            buffer.put((byte) i);
        }
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            slice.put((byte) (i *10));
        }
        buffer.position(0);
        while (buffer.remaining() > 0){
            System.out.println(buffer.get());
        }
    }

    @Test
    public void buffer02() throws Exception{
        FileInputStream inputStream = new FileInputStream("C:\\Users\\18236\\Desktop\\log2.txt");
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream("C:\\Users\\18236\\Desktop\\log.txt");
        FileChannel outputStreamChannel = outputStream.getChannel();

        // 创建直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true){
            buffer.clear();
            int read = inputStreamChannel.read(buffer);
            if (read == -1){
                break;
            }
            buffer.flip();
            outputStreamChannel.write(buffer);
        }
    }
}
