package com.h.test.io.netty.server;

import org.junit.Test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SockctServer {

    @Test
    public void test(){
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            while (true){
                System.out.println("等待连接.......");
                // 阻塞方法
                Socket accept = serverSocket.accept();
                System.out.println("有客户端加入连接....");
                handler(accept);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handler(Socket clientSocket) throws IOException {
        byte[] bytes = new byte[1024];
        System.out.println("准备读取客户端数据.....");
        int read = clientSocket.getInputStream().read(bytes);
        System.out.println("read 结束");
        if(read != -1){
            System.out.println("接受客户端数据为:"+ new String(bytes,0,read));
        }
        clientSocket.getOutputStream().write("hello Client".getBytes());
        clientSocket.getOutputStream().flush();
    }
}
