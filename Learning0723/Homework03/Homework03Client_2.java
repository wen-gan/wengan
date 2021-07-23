package com.wengan.Homework.Homework03;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03Client_2 {
    public static void main(String[] args) throws Exception {

        //接受用户输入，指定下载文件
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名：");
        String downloadFileName = scanner.next();

        Socket socket = new Socket(InetAddress.getLocalHost(), 9998);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());

        socket.shutdownOutput();

        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //得到一个输出流，准备将 bytes 写入到磁盘文件
        String filePath = "G:\\" + downloadFileName + ".mp3";
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);

        //关闭相关资源
        bos.close();
        bufferedInputStream.close();
        outputStream.close();
        socket.close();

        System.out.println("客户端下载完毕，正式退出...");
    }
}
