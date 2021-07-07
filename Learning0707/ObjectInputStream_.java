package com.wengan.file.inputstream_;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author 文淦
 * @version 1.0
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //指定反序列化文件
        String filePath = "G:\\story.txt";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取(反序列化)的顺序必须和你保存数据(序列化)的顺序一致
        //否则会出现异常

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println("运行类型= " + dog.getClass());
        System.out.println("dog信息" + dog);//底层 Object ---> Dog

        //如果希望调用Dog方法，需要向下转型
        //需要将Dog类的定义，拷贝到可以引用的位置


        //关闭流
        ois.close();
    }
}
