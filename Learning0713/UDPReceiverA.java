package com.wengan.udp;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author 文淦
 * @version 1.0
 * UDP接收器
 */
public class UDPReceiverA {
    public static void main(String[] args) throws SocketException {
        //1. 创建一个 DatagramSocket 对象，准备在9999接受数据
        DatagramSocket socket = new DatagramSocket(9999);

    }
}
