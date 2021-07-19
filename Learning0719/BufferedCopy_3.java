package com.wengan.file.writer_;

import java.io.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class BufferedCopy_3 {
    public static void main(String[] args) throws IOException {
        String fileread = "G:\\story2.txt";
        String filewrite = "G:\\story3.txt";

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        bufferedReader = new BufferedReader(new FileReader(fileread));
        bufferedWriter = new BufferedWriter(new FileWriter(filewrite));

        String readline = "";
        while ((readline = bufferedReader.readLine()) != null) {
            System.out.println(readline);
            bufferedWriter.newLine();
            bufferedWriter.write(readline);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
