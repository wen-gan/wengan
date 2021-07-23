package com.wengan.Homework.Homework02;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02Reader_4 {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data,0,length);
        System.out.println(s);

        String answer = " ";
        if ("四大名著".equals(s)) {
            answer = "四大名著有：三国演义、红楼梦、水浒传、西游记";
        }else {
            answer = "???";
        }

        byte[] buf = answer.getBytes();
        packet = new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.12.1"),9998);

        socket.send(packet);

        socket.close();
        System.out.println("服务端退出...");
    }
}
