package com.wengan.live;

public class Professor extends Teacher{
    public Professor(String name, String gender, int phonenum, String nativeplace, String hobby, String title, String xueyuan) {
        super(name, gender, phonenum, nativeplace, hobby, title, xueyuan);
    }

    @Override
    public void teach() {
        super.teach();
        System.out.println(getName()+"专注于科研...");
    }
}
