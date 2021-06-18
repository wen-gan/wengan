package com.wengan.Homework.PersonSystem;

/**
 * @author 文淦
 * @version 1.0
 */
public class Lecturer extends Teacher{
    public Lecturer(int age, String gender, int phone, String nativeplace, String academic, String rank) {
        super(age, gender, phone, nativeplace, academic, rank);
    }

    @Override
    public void teaching() {
        System.out.println("授课");
    }
}
