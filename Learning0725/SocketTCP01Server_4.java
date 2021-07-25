package com.wengan.socket_;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class SocketTCP01Server_4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端在9999端口监听 等待连接");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        byte[] buf = new byte[1024];
        int length;
        while ((length = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,length));
        }

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("服务端已收到".getBytes());

        socket.shutdownOutput();

        outputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出");
    }
}
