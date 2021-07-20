package com.wengan.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class SocketTCP03Server_2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9998);
        System.out.println("服务器在9998端口监听 等待配对...");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readline = bufferedReader.readLine();
        System.out.println(readline);

        //输出
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端退出...");
    }
}
