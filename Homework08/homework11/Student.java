package com.wengan.Homework.homework11;

public class Student extends Person{
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void run() {
        System.out.println("student run");;
    }
    public void study(){
        System.out.println("student study...");
    }
}
