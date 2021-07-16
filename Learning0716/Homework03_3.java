package com.wengan.file.Homework;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03_3 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        properties.load(new FileReader("src\\dog.properties"));

        properties.list(System.out);

        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "");
        String color = properties.get("color") + "";

        Dog3 dog3 = new Dog3(name, age, color);
        System.out.println("====dog对象信息====");
        System.out.println(dog3);

        String filePath = "G:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeObject(dog3);

        objectOutputStream.close();
        System.out.println("dog3 对象序列化完成");
    }

    @Test
    public void m1() throws IOException, ClassNotFoundException {
        //反序列化
        String filePath = "G:\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        Dog dog = (Dog)objectInputStream.readObject();
        System.out.println("====反序列化后 dog3====");
        System.out.println(dog);

        objectInputStream.close();
    }
}

class Dog3 {
    private String name;
    private int age;
    private String color;

    public Dog3(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog3{" +
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