package com.wengan.file.Homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework01_4 {
    public static void main(String[] args) throws IOException {
        String distName = "G:\\mytemp";

        File file = new File(distName);

        if (!file.exists()) {
            if (file.mkdir()) {
                System.out.println("创建文件夹成功");
            }else {
                System.out.println("创建文件夹失败");
            }
        }else {
            System.out.println("该文件夹已存在");
        }

        String fileName = distName + "\\hello.txt";
        File file1 = new File(fileName);
        if (!file1.exists()) {
            if (file1.createNewFile()) {
                System.out.println("创建文件成功");

                BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                bw.write("湖人总冠军");
                bw.close();
            }else {
                System.out.println("文件创建失败");
            }
        }else {
            System.out.println("该文件已经存在");
        }
    }
}
