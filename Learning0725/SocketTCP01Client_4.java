package com.wengan.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class SocketTCP01Client_4 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("客户端进行请求".getBytes());

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] buf = new byte[1024];
        int length;
        while ((length = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,length));
        }

        inputStream.close();
        outputStream.close();
        socket.close();
        System.out.println("客户端退出");
    }
}
