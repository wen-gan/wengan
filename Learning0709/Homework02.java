package com.wengan.file.Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        String filePath = "G:\\story2.txt";

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String line = "";
        int lineNum = 0;
        while ((line = br.readLine()) != null) {
            lineNum++;
            line += "-------" + lineNum;
            System.out.println(line);
        }

        br.close();
    }
}
