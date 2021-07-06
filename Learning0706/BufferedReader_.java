package com.wengan.file.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author 文淦
 * @version 1.0
 */
public class BufferedReader_ {
    public static void main(String[] args) throws Exception{
        String filePath = "G:\\story.txt";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;//按行读取  效率高
        //bufferedReader.readLine() 是按行读取文件
        //当返回null时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //关闭流
        //注意  只需要关闭bufferedReader  因为底层会自动关闭节点流FileReader
        bufferedReader.close();
    }
}
