package com.wengan.Homework.homework13;

public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, String sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    //老师独有的教学方法：teach
    public void teach(){
        System.out.println("我承诺，我会认真教学");
    }
    //重写玩耍方法

    @Override
    public String play() {
        return super.play()+"爱下象棋";
    }

    //重写打印信息的方法

    @Override
    public void info() {
        System.out.println("老师的信息：");
        super.info();
        System.out.println("工龄："+getWork_age());
    }
}
