package com.wengan.file.Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02_2 {
    public static void main(String[] args) throws IOException {
        String filePath = "G:\\story.txt";

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String readLine = "";
        int count = 0;
        while ((readLine = br.readLine()) != null) {
            System.out.println(count++ + "----" +readLine);
        }

        br.close();
    }
}
