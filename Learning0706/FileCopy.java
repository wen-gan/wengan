package com.wengan.file.outputStream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) {
        //完成文件拷贝
        //创建文件的输入流，将文件读取到程序
        //创建文件的输出流，将读取到的文件数据写入到指定的文件中
        String srcFilePath = "G:\\hello.txt";
        String destFilePath = "G:\\hello1.txt";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);

            byte[] buf = new byte[1024];
            int readLen = 0;

            while ((readLen = fileInputStream.read(buf)) != -1) {
                //一定在读取到后一边读取，一边写入(buf,0, readLen)
                fileOutputStream.write(buf,0, readLen);
            }
            System.out.println("拷贝完成~");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
