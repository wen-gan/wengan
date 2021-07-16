package com.wengan.file.Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02_3 {
    public static void main(String[] args) throws IOException {
        String filePath = "G:\\story2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line = "";
        int len = 0;
        while ((line = bufferedReader.readLine()) != null) {
            len++;
            System.out.println(len + "------" +line);
        }

        bufferedReader.close();
    }
}
