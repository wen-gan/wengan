package com.wengan.Homework.Homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03Client_3 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名：");
        String downLoadFileName = scanner.next();

        Socket socket = new Socket(InetAddress.getLocalHost(), 9998);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downLoadFileName.getBytes());

        socket.shutdownOutput();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());

        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);
        String filePath = "G:\\" + downLoadFileName + ".mp3";
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePath));

        bufferedOutputStream.write(bytes);

        bufferedOutputStream.close();
        bufferedInputStream.close();
        outputStream.close();
        socket.close();

        System.out.println("客户端退出...");
    }
}
