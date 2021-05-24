package com.wengan.Homework;

public class homework01 {
    public static void main(String[] args){
        Person[] persons = new Person[3];
        persons[0] = new Person("jack",18,"老师");
        persons[1] = new Person("mike",49,"教练");
        persons[2] = new Person("tom",40,"教授");

        //输出当前数组
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);//默认对象的.toString()
        }
        //冒泡排序
        Person temp = null;//临时变量，用于交换
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if (persons[j].getAge() < persons[j+1].getAge()) {
                    temp = persons[j+1];
                    persons[j+1] = persons[j];
                    persons[j] = temp;
                }
            }
        }
        System.out.println("========================");
        //排序后的效果
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i]);//默认对象的.toString()
        }
    }
}
class Person{
    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{"+
                "name='"+name+'\''+
                ", age="+age+
                ", job="+job+'\''+
                '}';
    }
}