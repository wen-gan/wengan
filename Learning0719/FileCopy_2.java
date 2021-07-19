package com.wengan.file.outputStream_;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class FileCopy_2 {
    public static void main(String[] args) throws IOException {
        String srcfilePath = "G:\\hello.txt";
        String destfilePath = "G:\\hello1.txt";

        int readData = 0;
        byte[] bytes = new byte[1024];

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        while ((readData = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes,0, readData);
        }

        if (fileInputStream != null) {
            fileInputStream.close();
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }
}
