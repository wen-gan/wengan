package com.wengan.socket_;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 */
public class SocketTCP03Client_2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9998);

        OutputStream outputStream = socket.getOutputStream();

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readline = bufferedReader.readLine();
        System.out.println(readline);

        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
