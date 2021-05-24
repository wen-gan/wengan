package com.wengan.Homework.homework03;

public class Lecturer extends Teacher{
    private double grade = 1.1;

    public Lecturer(String name, int age, String title, double salary, double grade) {
        super(name, age, title, salary);
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.println("工资水平为："+getGrade());
    }
}
