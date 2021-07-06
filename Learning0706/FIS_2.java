package com.wengan.file.inputstream_;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class FIS_2 {
    public static void main(String[] args) {

    }
    @Test
    public void readFile02() throws IOException {
        String filePath = "G:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;

        fileInputStream = new FileInputStream(filePath);

        while ((readData = fileInputStream.read()) != -1) {
            System.out.print((char)readData);
        }

        fileInputStream.close();
    }
}
