package com.wengan.Homework.Homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework01Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9997);
        System.out.println("服务器9997 正在监听...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        String answer = "";
        if ("name".equals(s)) {
            answer = "我的nova";
        }else if ("hobby".equals(s)) {
            answer = "编写java程序";
        }else {
            answer = "没听清您说的...";
        }

        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //关闭流 socket serverSocket
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        bufferedWriter.close();
    }
}
