package com.wengan.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class TCPFileUploadServer_2 {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);
        System.out.println("服务器在7777接口监听....");
        Socket socket = serverSocket.accept();

        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);

        String destFilePath = "src\\qie2.png";
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFilePath));
        bos.write(bytes);
        bos.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("收到图片");
        bw.flush();
        socket.shutdownOutput();

        //关闭其他流
        bw.close();
        bis.close();
        socket.close();
        serverSocket.close();
    }
}
