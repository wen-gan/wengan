package com.wengan.encapsulation;

public class Encapsulation01 {
    public static void main(String[] args){
        Person person = new Person();
        person.setName("jack");
        person.setAge(30);
        person.setSalary(30000);
        System.out.println(person.info());
    }
}

class Person{
    public String name;//name 名字公开
    private int age;//age 年龄私有化
    private double salary;// salary 薪水私有化

    public String getName(){
        return name;
    }
    public void setName(String name){
        //加入对数据的校验
        if(name.length()>=2 && name.length()<=6) {
            this.name = name;
        }else{
            System.out.println("名字长度不对，需要2-6个字符，默认名字");
        }
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age>=1 && age<=120) {
            this.age = age;
        }else{
            System.out.println("年龄需要在1-120岁之间，给默认年龄18");
            this.age = 18;//给一个默认的年龄
        }
    }
    public double getSalary(){
        //可以在这里增加对当前对象权限的判断
        return salary;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }

    //编写一个方法用于输出
    public String info(){
        return "信息为 name="+name+" age="+age+" salary="+salary;
    }
}