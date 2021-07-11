package com.wengan.upload;


import com.wengan.upload.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 文淦
 * @version 1.0
 * 客户端 字符流
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception{

        //1. 创建客户端连接服务端 得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //2. 创建读取磁盘文件的输入流
        String filePath = "G:\\qie.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        //bytes 就是filePath 对应的字节数组
        byte[] bytes =  StreamUtils.streamToByteArray(bis);

        //通过socket获取到输出流，将bytes数据发送给服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);//将文件对应的字节数组的内容，写入到字符通道
        bis.close();
        socket.shutdownOutput();//设置写入数据的结束标记

        //接受从服务端回复的信息
        InputStream inputStream = socket.getInputStream();
        //使用StreamUtils 的方法，直接将inputStream 读取到的内容转换成字符串
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭相关的流
        inputStream.close();
        bos.close();
        socket.close();
    }
}
