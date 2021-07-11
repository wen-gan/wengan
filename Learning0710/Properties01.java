package com.wengan.file.Properties_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author 文淦
 * @version 1.0
 */
public class Properties01 {
    public static void main(String[] args) throws Exception{

        //读取mysql.properties 文件， 并得到ip, user, pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + "的值是" + split[1]);
        }

        br.close();
    }
}
