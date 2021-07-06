package com.wengan.file.outputStream_;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class FOS_2 {
    public static void main(String[] args) {

    }

    public void writeFile02() throws IOException {
        String filePath = "G:\\hello.txt";
        FileOutputStream fileOutputStream = null;

        fileOutputStream = new FileOutputStream(filePath);

        String str = "hello, world";

        fileOutputStream.write(str.getBytes());

        fileOutputStream.close();

    }
}
