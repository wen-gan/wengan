package com.wengan.Homework.Homework02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02Sender_2 {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(9998);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的问题：");
        String question = scanner.next();
        byte[] bytes = question.getBytes();

        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.12.1"), 8888);
        socket.send(packet);

        byte[] buf = new byte[1024];
        packet = new DatagramPacket(buf,buf.length);
        System.out.println("用户端接收...");
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        System.out.println(s);

        socket.close();
        System.out.println("用户端已退出...");
    }
}
