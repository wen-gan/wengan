package com.wengan.file.Homework;

import java.io.File;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework01_3 {
    public static void main(String[] args) throws IOException {
        String directFilePath = "G:\\mytemp";

        File file = new File(directFilePath);
        if (!(file.exists())) {
            //创建新的
            if (file.mkdir()) {
                System.out.println("文件" + directFilePath + "创建成功");
            }else {
                System.out.println("文件" + directFilePath + "创建失败");
            }
        }else {
            System.out.println("文件" + directFilePath + "已存在");
        }

        String filePath = directFilePath + "\\hello.txt";
        File file1 = new File(filePath);
        if (!(file1.exists())) {
            //创建新的
            if (file1.createNewFile()) {
                System.out.println("文件" + filePath + "创建成功");
            }else {
                System.out.println("文件" + filePath + "创建失败");
            }
        }else {
            System.out.println("文件" + filePath + "已创建");
        }
    }
}
