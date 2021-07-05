package com.wengan.file.inputstream_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 *
 * FIleInputStream的使用（字节输入流  文件---> 程序）
 */
public class FIleInputStream_ {
    public static void main(String[] args) {

    }

    //读取  单个字符读取效率较低
    @Test
    public void readFile01() {
        String filePath = "G:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;

        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止
            //如果返回-1，则表示读取完毕
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char)readData);//转换成char显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//完成转换后 一定要关闭字节流 节省资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void readFile02() {
        String filePath = "G:\\hello.txt";
        //字节数组
        byte[] buf = new byte[8];
        int readLen = 0;
        FileInputStream fileInputStream = null;

        try {
            //创建 FileInputStream 对象，用于读取文件
            fileInputStream = new FileInputStream(filePath);

            //从该输入流读取一个字节的数据，如果没有输入可用，此方法将阻止
            //如果返回-1，则表示读取完毕
            while ((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));//转换成char显示
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//完成转换后 一定要关闭字节流 节省资源
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
