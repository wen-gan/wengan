package com.wengan.live;

public class Lecturer extends Teacher{
    public Lecturer(String name, String gender, int phonenum, String nativeplace, String hobby, String title, String xueyuan) {
        super(name, gender, phonenum, nativeplace, hobby, title, xueyuan);
    }

    @Override
    public void teach() {
        super.teach();
        System.out.println(getName() + "专注于上课...");
    }
}
