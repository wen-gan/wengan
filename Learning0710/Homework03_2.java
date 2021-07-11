package com.wengan.file.Homework;

import java.io.*;
import java.util.Properties;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03_2 {
    public static void main(String[] args) throws IOException{
        String filePath = "src\\dog.properties";

        Properties properties = new Properties();

        properties.load(new FileReader(filePath));

        properties.list(System.out);

        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "");
        String color = properties.get("color") + "";

        Dog1 dog = new Dog1(name, age, color);
        System.out.println("====dog 对象信息====");
        System.out.println(dog);

        //序列化
        String scrfilePath = "G:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(scrfilePath));
        objectOutputStream.writeObject(dog);

        objectOutputStream.close();
        System.out.println("dog 对象序列化完成...");
    }

    public void m2() throws IOException, ClassNotFoundException {
        String destfilePath = "G:\\story.txt";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(destfilePath));
        Dog dog = (Dog)ois.readObject();

        System.out.println("====反序列化后 dog====");
        System.out.println(dog);

        ois.close();
    }
}

class Dog1 implements Serializable {
    private String name;
    private int age;
    private String color;

    public Dog1(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}