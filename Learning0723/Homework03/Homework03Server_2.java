package com.wengan.Homework.Homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03Server_2 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9998);
        System.out.println("服务器在端口9998监听 等待连接");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        String downloadFile = "";
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            downloadFile += new String(bytes,0,len);
        }
        System.out.println("客户端希望下载的文件名 = " + downloadFile);

        String resFileName = "";
        if ("高山流水".equals(resFileName)) {
            resFileName = "src\\高山流水.mp3";
        }else {
            resFileName = "src\\无名.mp3";
        }

        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(resFileName));
        byte[] bytes1 = StreamUtils.streamToByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(socket.getOutputStream());
        //写入数据通道 返回给客户端
        bufferedOutputStream.write(bytes1);
        socket.shutdownOutput();

        bufferedInputStream.close();
        inputStream.close();
        serverSocket.close();
        System.out.println("服务端退出...");
    }
}
