package com.wengan.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class TCPFileUploadServer_4 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器在8888端口监听 等待连接...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        String destFilePath = "src\\qie.png";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("已收到图片");
        bufferedWriter.flush();
        socket.shutdownOutput();

        bufferedWriter.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端已退出...");
    }
}
