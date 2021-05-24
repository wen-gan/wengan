package com.wengan.Homework.homework13;

public class Person {
    private String name;
    private String sex;
    private int age;

    public Person(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    //打印基础信息的方法
    public void info(){
        System.out.println("姓名："+getName()+"\n"+"年龄："+getAge()+"\n"
        +"性别："+getSex());
    }
    //玩的方法
    public String play(){
        return getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
