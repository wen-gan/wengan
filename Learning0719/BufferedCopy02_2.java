package com.wengan.file.outputStream_;

import java.io.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class BufferedCopy02_2 {
    public static void main(String[] args) throws IOException {
        String filePathout = "G:\\story.txt";
        String filePathin = "G:\\story1.txt";

        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        byte[] bytes = new byte[1024];
        int readlen = 0;

        bufferedInputStream = new BufferedInputStream(new FileInputStream(filePathout));
        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(filePathin));

        while ((readlen = bufferedInputStream.read(bytes)) != -1){
            System.out.println(new String(bytes,0,readlen));
            bufferedOutputStream.write(bytes,0,readlen);
        }
        System.out.println("copy完成");
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
