package com.wengan.file.writer_;

import java.io.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class BufferedCopy_ {
    public static void main(String[] args) throws Exception {
        String srcPath = "G:\\hello.txt";
        String destPath = "G:\\hello1.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destPath));

        String line;//逐行读取
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("读取成功");
            bufferedWriter.write(line);
        }
        System.out.println("拷贝完成");
        bufferedReader.close();
        bufferedWriter.close();
    }
}
