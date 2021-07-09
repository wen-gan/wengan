package com.wengan.file.writer_;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {

        String filePath = "G:\\hello.txt";
        //new FileWriter(filePath, true) 表示以追加的方式输入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true));

        bufferedWriter.write("湖人总冠军，詹姆斯MVP");

        bufferedWriter.close();
    }
}
