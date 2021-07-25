package com.wengan.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class TCPFileUploadServer_5 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在端口9999监听 等待连接....");
        Socket socket = serverSocket.accept();

        String filePath = "src\\100.png";

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("服务端已收到图片");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        socket.shutdownOutput();

        bufferedWriter.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端已退出....");
    }
}
