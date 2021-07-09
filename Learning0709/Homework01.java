package com.wengan.file.Homework;

import java.io.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) throws IOException {

        String directoryPath = "G:\\mytemp";

        File file = new File(directoryPath);
        if (!file.exists()) {
            //创建
            if (file.mkdir()){
                System.out.println("创建" + directoryPath + "成功");
            }else {
                System.out.println("创建" + directoryPath + "失败");
            }
        }else {
            System.out.println("该文件夹已经存在...");
        }

        String filePath = directoryPath + "\\hello3.txt";
        file = new File(filePath);
        if (!file.exists()) {
            //创建文件
            if (file.createNewFile()) {
                System.out.println(filePath + "创建成功");

                //文件存在就写入hello, world
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write("hello ~~~ 湖人总冠军");
                bw.close();

            }else {
                System.out.println(filePath + "创建失败");
            }
        }else {
            //如果文件已经存在则给出提示
            System.out.println(filePath + "文件已经存在");
        }


    }
}
