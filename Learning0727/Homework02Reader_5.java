package com.wengan.Homework.Homework02;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02Reader_5 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        System.out.println("接收端正在等待接受...");
        socket.receive(packet);

        byte[] data = packet.getData();
        int length = packet.getLength();
        java.lang.String s = new java.lang.String(data, 0, length);

        java.lang.String answer = "";
        if ("四大名著是哪些".equals(s)) {
            answer = "四大名著有：三国演义、红楼梦、水浒传、西游记";
        }else {
            answer = "what?";
        }

        data = answer.getBytes();

        packet = new DatagramPacket(data, data.length, InetAddress.getByName("196.168.12.1"),8888);

        socket.send(packet);

        socket.close();
        System.out.println("服务端退出...");
    }
}
