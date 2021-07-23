package com.wengan.Homework.Homework03;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("服务器9999端口监听 等待连接...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        byte[] bytes = new byte[1024];
        int len = 0;
        String downloadFileName = "";
        while ((len = inputStream.read()) != -1) {
            downloadFileName += new String(bytes,0,len);
        }
        System.out.println("客户端希望下载的文件名 = " + downloadFileName);

        String resFileName = "";
        if ("高山流水".equals(resFileName)) {
            resFileName = "src\\高山流水.mp3";
        }else {
            resFileName = "src\\无名.mp3";
        }

        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(resFileName));
        //使用工具类StreamUtils， 读取文件到一个字节数组
        byte[] bytes1 = StreamUtils.streamToByteArray(bufferedInputStream);

        //在得到Socket关联的输出流
        BufferedOutputStream bos =
                new BufferedOutputStream(socket.getOutputStream());
        //写入数据通道 返回给客户端
        bos.write(bytes1);
        socket.shutdownOutput();

        bufferedInputStream.close();
        inputStream.close();
        serverSocket.close();
        System.out.println("服务端退出...");
    }
}
