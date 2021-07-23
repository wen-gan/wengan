package com.wengan.Homework.Homework02;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings("all")
public class Homework02Reader {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(9998);

        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        System.out.println("接收端正在等待接受数据...");
        socket.receive(packet);

        int length = packet.getLength();
        byte[] data = packet.getData();
        String s = new String(data, 0, length);
        //判断接收到的信息是什么
        String answer = "";
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
