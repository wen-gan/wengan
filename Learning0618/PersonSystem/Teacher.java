package com.wengan.Homework.PersonSystem;

/**
 * @author 文淦
 * @version 1.0
 */
public class Teacher extends Person{
    //教师有职称、所属学院属性和授课的职能
    private String academic;
    private String rank;

    public Teacher(int age, String gender, int phone, String nativeplace, String academic, String rank) {
        super(age, gender, phone, nativeplace);
        this.academic = academic;
        this.rank = rank;
    }

    public void teaching() {
        System.out.println("授课");
    }
}
