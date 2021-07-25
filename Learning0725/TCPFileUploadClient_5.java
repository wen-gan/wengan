package com.wengan.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class TCPFileUploadClient_5 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        String filePath = "G:\\100.jpg";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(filePath));
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(bytes);
        bufferedOutputStream.close();

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bufferedInputStream.close();
        socket.close();
        System.out.println("服务端退出...");


    }
}
