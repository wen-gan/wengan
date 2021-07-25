package com.wengan.file.Transformation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author 文淦
 * @version 1.0
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {

        String filePath = "G:\\hello.txt";
        String charSet = "utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hi，湖人总冠军");
        osw.close();
        System.out.println("按照 " + charSet + "保持文件成功~");
//        BufferedWriter bw = new BufferedWriter(osw);


    }
}
