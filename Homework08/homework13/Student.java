package com.wengan.Homework.homework13;

public class Student extends Person{
    private int stu_id;

    public Student(String name, String sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    //学生独有的方法：study
    public void study(){
        System.out.println("我承诺，我会好好学习");
    }
    //重写玩耍方法

    @Override
    public String play() {
        return super.play()+"爱玩足球";
    }

    //重写打印信息的方法

    @Override
    public void info() {
        System.out.print("学生的信息："+"\n");
        super.info();
        System.out.println("学号："+getStu_id());
    }
}
