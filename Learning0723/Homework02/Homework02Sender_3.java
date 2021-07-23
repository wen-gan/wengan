package com.wengan.Homework.Homework02;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02Sender_3 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9999);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的问题：");
        String queation = scanner.next();
        byte[] buf = queation.getBytes();

        DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("192.168.12.1"), 8888);
        socket.send(packet);

        byte[] bytes = new byte[1024];
        packet = new DatagramPacket(bytes, bytes.length);

        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);

        System.out.println(s);

        socket.close();
        System.out.println("服务端已退出...");
    }
}
