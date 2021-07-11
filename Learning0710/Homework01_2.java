package com.wengan.file.Homework;

import java.io.File;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework01_2 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "G:\\mytemp";

        File file = new File(directoryPath);
        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("创建 mytemp 成功");
            }else {
                System.out.println("创建 mytemp 失败");
            }
        }else {
            System.out.println(directoryPath + "以及存在");
        }

        String filePath = directoryPath + "\\hello.txt";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            if (file1.createNewFile()) {
                System.out.println(filePath + "创建成功");
            }else {
                System.out.println(filePath + "创建失败");
            }
        }else {
            System.out.println(filePath + "已经存在");
        }
    }
}
