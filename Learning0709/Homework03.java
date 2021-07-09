package com.wengan.file.Homework;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        properties.load(new FileReader("src\\dog.properties"));

        properties.list(System.out);

        String name = properties.get("name") + "";//Object -> String
        int age = Integer.parseInt(properties.get("age") + "");//Object -> int
        String color = properties.get("color") + "";//Object -> String

        Dog dog = new Dog(name, age, color);
        System.out.println("====dog对象信息====");
        System.out.println(dog);


        //序列化（把数据的值和类型都进行保存）
        String serFilePath = "G:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFilePath));
        oos.writeObject(dog);

        //关闭流
        oos.close();
        System.out.println("dog对象序列化完成...");
    }

    @Test
    public void m1() throws Exception{
        //反序列化
        String serFilePath = "G:\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog)objectInputStream.readObject();

        System.out.println("====反序列化后 dog====");
        System.out.println(dog);

        objectInputStream.close();
    }
}

class Dog implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}