package com.wengan.file.Properties_;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 文淦
 * @version 1.0
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用 Properties 类来读取 mysql.properties 文件

        Properties properties = new Properties();

        properties.load(new FileReader("src\\mysql.properties"));

        properties.list(System.out);

        //根据key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码=" + pwd);
    }
}
