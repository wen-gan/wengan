package com.wengan.Homework.Homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03Server_3 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9998);
        System.out.println("服务器在9998端口监听 等待连接");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        while ((len = inputStream.read()) != -1) {
            downLoadFileName += new String(bytes,0,len);
        }
        System.out.println("客户想下载的文件名：" + downLoadFileName);

        String resFileName = "";
        if ("高山流水".equals(resFileName)) {
            resFileName = "src\\高山流水.mp3";
        }else {
            resFileName = "src\\无名.mp3";
        }

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(resFileName));
        byte[] bytes1 = StreamUtils.streamToByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes1);
        socket.shutdownOutput();

        bufferedOutputStream.close();
        bufferedInputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务端退出...");

    }
}
