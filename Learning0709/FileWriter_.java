package com.wengan.file.writer_;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class FileWriter_ {
    public static void main(String[] args) {
        String filePath = "G:\\storyWrite.txt";
        FileWriter fileWriter = null;
        char[] chars = {'a','b','c'};
        int data = 0;

        try {
            fileWriter = new FileWriter(filePath, true);//默认是覆盖
            fileWriter.write('w');

            fileWriter.write(chars);

            fileWriter.write("湖人总冠军".toCharArray(),0,5);

            fileWriter.write("学习Java");

            fileWriter.write("湖人总冠军", 0,3);

            System.out.println("输入完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
