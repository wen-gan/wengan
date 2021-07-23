package com.wengan.Homework.Homework01;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework01Client_3 {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的问题：");
        String question = scanner.next();

        bufferedWriter.write(question);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
