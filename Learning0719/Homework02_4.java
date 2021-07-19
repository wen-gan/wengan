package com.wengan.file.Homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02_4 {
    public static void main(String[] args) throws IOException {
        String filePath = "G:\\story2.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String readLine = "";
        int lineNum = 0;

        while ((readLine = bufferedReader.readLine()) != null) {
            lineNum++;
            System.out.println(lineNum + " --------- " +readLine);
        }

        bufferedReader.close();
    }
}
