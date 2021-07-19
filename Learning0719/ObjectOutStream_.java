package com.wengan.file.outputStream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author 文淦
 * @version 1.0
 * 利用ObjectOutStream，完成数据的序列化
 */
public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {
        String filePath = "G:\\story.txt";
        //序列化后，保存的文件格式不是存文本，而是按照他的格式来保存的

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeInt(1000);//int --->  Integer (实现了Serializable)
        oos.writeBoolean(true);//boolean ---> Boolean (实现了Serializable)
        oos.writeChar('a');//char ---> Character (实现了Serializable)
        oos.writeDouble(9.5);//double ---> Double (实现了Serializable)
        oos.writeUTF("湖人总冠军");//String

        //保存一个dog对象
        oos.writeObject(new Dog("小黄", 2));


        oos.close();
        System.out.println("数据保存完毕（序列化形式）");
    }
}
//如果需要序列化某个对象，则必须实现Serializable接口
class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}