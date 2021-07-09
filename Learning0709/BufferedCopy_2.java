package com.wengan.file.writer_;

import java.io.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class BufferedCopy_2 {
    public static void main(String[] args) throws IOException {
        String srcPath = "G:\\story.txt";
        String destPath = "G:\\story2.txt";

        String readLen = "";
        BufferedReader br = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destPath));

        while ((readLen = br.readLine()) != null) {
            bw.write(readLen);
        }

        System.out.println("拷贝完成");

        br.close();
        bw.close();
    }
}
