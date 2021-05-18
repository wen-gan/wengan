package com.wengan.live;

public class Undergraduate extends Student{
    public Undergraduate(String name, String gender, int phonenum, String nativeplace, String hobby, String education, String xueyuan) {
        super(name, gender, phonenum, nativeplace, hobby, education, xueyuan);
    }

    @Override
    public void studying() {
        super.studying();
        System.out.println(getName() + "正在写毕设");
    }
}
