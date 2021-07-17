package com.wengan.upload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 文淦
 * @version 1.0
 */
public class TCPFileUploadClient_2 {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket(InetAddress.getLocalHost(), 7777);
        String filePath = "G:\\qie.jpg";

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        byte[] bytes =  StreamUtils.streamToByteArray(bis);

        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes);
        bos.close();
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        inputStream.close();
        bis.close();
        socket.close();
    }
}
