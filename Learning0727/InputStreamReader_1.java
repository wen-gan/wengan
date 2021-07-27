package com.wengan.file.Transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 文淦
 * @version 1.0
 */
public class InputStreamReader_1 {
    public static void main(String[] args) throws IOException {
        String filePath = "G:\\hello.txt";

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "gbk");

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String s = bufferedReader.readLine();
        System.out.println(s);

        System.out.println("读取到的内容为：\n" + s);

        bufferedReader.close();
        inputStreamReader.close();
    }
}
