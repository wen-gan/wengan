package com.wengan.Homework.Homework01;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework01Server_2 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务器在端口9999监听 等待连接...");

        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String s = br.readLine();
        String answer = "";
        if ("name".equals(s)) {
            answer = "我的nova";
        }else if ("hobby".equals(s)) {
            answer = "编写java程序";
        }else {
            answer = "没听清您说的...";
        }

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(answer);
        bw.newLine();
        bw.flush();

        br.close();
        serverSocket.close();
        socket.close();
        bw.close();
        System.out.println("服务端退出...");
    }
}
