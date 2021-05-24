package com.wengan.Homework.homework03;

public class Teacher {
    private String name;
    private int age;
    private String title;
    private double salary;

    public Teacher(String name, int age, String title, double salary) {
        this.name = name;
        this.age = age;
        this.title = title;
        this.salary = salary;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //老师的业务方法
    public void introduce(){
        System.out.println("老师：" + getName() + " 年龄：" +
                getAge()+" 职称："+ getTitle()+" 基本工资："+getSalary());
    }
}
