package com.wengan.file;

import com.sun.xml.internal.fastinfoset.tools.FI_DOM_Or_XML_DOM_SAX_SAXEvent;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author 文淦
 * @version 1.0
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    //方式1 new File(String pathname)
    @Test
    public void create01() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式2 new File(File parent, String child)  根据父目录文件+子路径创建
    public void create02() {
        File parentfile = new File("d:\\");
        String fileName = "news2.txt";

        File file = new File(parentfile, fileName);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //方式3 new File(String parent, String child)
    public void create03() {
        String parentPath = "d:\\";
        String filePath = "news3.txt";
        File file = new File(parentPath, filePath);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void m1() {
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            System.out.println("该文件不存在");
        }
    }

    public void m3() {
        String directory = "d:\\demo\\a\\b\\c";//创建多级目录
        File file = new File(directory);

        if (file.exists()) {
            System.out.println(directory + "存在...");
        }else {
            if (file.mkdir()) {
                System.out.println(directory + "创建成功");
            }else {
                System.out.println(directory + "创建失败");
            }
        }
    }
}
