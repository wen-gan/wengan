package com.wengan.socket_;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 * 使用字符流方式
 */
@SuppressWarnings({"all"})
public class SocketTCP03Server {
    public static void main(String[] args) throws IOException {
        //1. 在本机的 9999端口监听  等待连接
        //   要求在本机没有其他服务器在监听 9999 否则会阻塞
        //   ServerSocket 可以通过 accept() 来连接多个服务器
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端，在9999端口监听，等待连接...");

        //2. 当没有客户端连接9999端口时，程序会阻塞，等待连接
        //   如果有客户端连接，则会返回Socket对象，程序继续
        Socket socket = serverSocket.accept();

        System.out.println("服务端 socket = " + socket.getClass());

        //3. 通过socket.getInputStream() 读取
        //   客户端写入到数据通道的数据，显示
        InputStream inputStream = socket.getInputStream();

        //4. IO读取 使用字符流 使用转换流InputStreamReader 将 inputStream 转换成字符流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //5. 获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        //   使用字符输出流的方式回复信息
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, client 字符流");
        bufferedWriter.newLine();//插入换行符，以表示写入的内容结束，否则数据不会写入数据通道
        bufferedWriter.flush();//如果使用的字符流，需要手动刷新，否组数据不会写入数据通道

        //6. 关闭流 socket serverSocket
        bufferedReader.close();
        socket.close();
        serverSocket.close();
        bufferedWriter.close();


    }
}
