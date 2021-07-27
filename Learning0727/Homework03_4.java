package com.wengan.file.Homework;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Properties;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03_4 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();

        properties.load(new FileReader("src\\dog.properties"));

        properties.list(System.out);

        String name = properties.get("name") + "";
        int age = Integer.parseInt(properties.get("age") + "");
        String color = properties.get("color") + "";

        Dogs dogs = new Dogs(name, age, color);
        System.out.println("dog的信息");
        System.out.println(dogs);

        String filePath = "G:\\dog.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeObject(dogs);

        objectOutputStream.close();
        System.out.println("dog对象序列化完成");
    }
}

class Dogs{
    String name;
    int age;
    String color;

    public Dogs(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
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