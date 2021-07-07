package com.wengan.file.outputStream_;

import java.io.*;

/**
 * @author 文淦
 * @version 1.0
 * 使用BufferedOutputStream 和 BufferedInputStream
 */
@SuppressWarnings({"all"})
public class BufferedCopy02_ {
    public static void main(String[] args) {
        String srcfilePath = "G:\\story.txt";
        String destfilePath = "G:\\story2.txt";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcfilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destfilePath));

            //循环读取文件, 并写入destfilePath
            byte[] buff = new byte[1024];
            int readLen = 0;
            while ((readLen = bis.read(buff)) != -1) {
                bos.write(buff, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流， 关闭外层的处理流即可， 底层会去关闭节点流
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
