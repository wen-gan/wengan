package com.wengan.live;

public class doctor extends Student{
    public doctor(String name, String gender, int phonenum, String nativeplace, String hobby, String education, String xueyuan) {
        super(name, gender, phonenum, nativeplace, hobby, education, xueyuan);
    }

    @Override
    public void studying() {
        super.studying();
        System.out.println(getName() + "发sci");
    }
}
