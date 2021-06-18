package com.wengan.Homework.PersonSystem;

/**
 * @author 文淦
 * @version 1.0
 */
public class Student extends Person{
    //学生有学历、所属学院属性和上课的职能，
    private String xueli;
    private String academic;

    public Student(int age, String gender, int phone, String nativeplace, String xueli, String academic) {
        super(age, gender, phone, nativeplace);
        this.xueli = xueli;
        this.academic = academic;
    }

    public void studying() {
        System.out.println("学习");
    }

}
