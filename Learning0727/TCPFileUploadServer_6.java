package com.wengan.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class TCPFileUploadServer_6 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听 等待连接...");
        Socket socket = serverSocket.accept();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        String destPath = "src\\100.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("服务端已收到照片");

        bufferedWriter.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端已退出...");
    }
}
