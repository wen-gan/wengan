package com.wengan.live0609;

public class Undergraduate extends Student implements Studying,Hobby{

    public Undergraduate(int age, String gender, String tel, String address, String rank, String school) {
        super(age, gender, tel, address, rank, school);
    }

    @Override
    public void study() {
        System.out.println("硕士生专注于发EI");
    }
}
