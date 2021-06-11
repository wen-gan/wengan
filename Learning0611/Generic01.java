package com.wengan.Learning0611.Homework_Exception.generic_;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Generic01 {
    public static void main(String[] args){
        //传统方法解决
//        ArrayList arrayList = new ArrayList();
//        arrayList.add(new Dog("旺财",10));
//        arrayList.add(new Dog("发财",5));
//        arrayList.add(new Dog("小黄",1));
//        for(Object o : arrayList){
//            Dog dog = (Dog)o;
//            System.out.println(dog.getName() + "-" + dog.getAge());
//        }

        //使用泛型解决
        //在遍历是时候可以直接取出 Dog 类型而不是 Object
        ArrayList<Dog> arrayList = new ArrayList<Dog>();
        arrayList.add(new Dog("旺财",10));
        arrayList.add(new Dog("发财",5));
        arrayList.add(new Dog("小黄",1));
        //arrayList.add(new Cat("小白",20));
        System.out.println("使用泛型");
        for (Dog dog : arrayList){
            System.out.println(dog.getName() + "-" + dog.getAge());
        }
    }
}

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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
}
class Cat{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
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
}