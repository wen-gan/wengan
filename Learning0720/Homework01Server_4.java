package com.wengan.Homework.Homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework01Server_4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在9999端口监听 等待连接...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        String answer = "";
        if ("name".equals(s)) {
            answer = "我的nova";
        }else if ("hobby".equals(s)) {
            answer = "学习java";
        }else {
            answer = "没听清...";
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器退出");
    }
}
