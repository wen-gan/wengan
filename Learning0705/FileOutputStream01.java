package com.wengan.file.outputStream_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class FileOutputStream01 {
    public static void main(String[] args) {

    }


    //使用 FileOutputStream 将数据写入到文件中
    //如果该文件不存在，则创建该文件
    @Test
    public void writeFile() {
        //创建 FileOutputStream对象
        String filePath = "G:\\writeFile.txt";
        FileOutputStream fileOutputStream = null;

        try {
            //得到对象
            //new FileOutputStream(filePath) 的创建方式，每一次运行，写入的内容会覆盖原来有的内容
            //new FileOutputStream(filePath, true) 的创建方式，每一次运行，写入的内容会追加到文件后面
            fileOutputStream = new FileOutputStream(filePath);
            //写入字节
//            fileOutputStream.write('w');
            //写入字符串
            String str = "hello,world";
            //该方法可以把一个字符串--->字节数组
            fileOutputStream.write(str.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
