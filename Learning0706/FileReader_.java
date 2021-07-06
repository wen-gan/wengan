package com.wengan.file.reader_;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class FileReader_ {
    public static void main(String[] args) {
        String filePath = "G:\\story.txt";
        FileReader fileReader = null;
        int data = 0;
        char[] buf = new char[8];
        // 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //循环读取 使用read 单个字符读取
            while ((data = fileReader.read(buf)) != -1){
                System.out.print(new String(buf, 0, data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
