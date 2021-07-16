package com.wengan.file.Transformation;

import java.io.*;

/**
 * @author 文淦
 * @version 1.0
 * 使用 InputStreamReader 转换流解决中文乱码问题
 * 将字节流 FileInputStream 转换成字符流 InputStreamReader ，指定编码 gbk/UTF-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException{
        String filePath = "G:\\hello.txt";
        //把 new FileInputStream(filePath) 转成 InputStreamReader
        //指定编码 GBK
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //把 InputStreamReader 传入 BufferedReader
        BufferedReader br = new BufferedReader(isr);
        //读取
        String s = br.readLine();
        System.out.println("读取到的内容" + s);
        //关闭外层流
        br.close();
    }
}
