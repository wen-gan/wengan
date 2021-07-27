package com.wengan.file.Transformation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author 文淦
 * @version 1.0
 */
public class OutputStreamWriter_1 {
    public static void main(String[] args) throws IOException {

        String filePath = "G:\\hello10.txt";
        String charSet = "utf-8";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath),charSet);

        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("hello 您好");

        bufferedWriter.close();
        outputStreamWriter.close();
    }
}
