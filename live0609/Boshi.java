package com.wengan.live0609;

public class Boshi extends Student implements Studying,Hobby{

    public Boshi(int age, String gender, String tel, String address, String rank, String school) {
        super(age, gender, tel, address, rank, school);
    }

    @Override
    public void study() {
        System.out.println("博士生专注于发SCI");
    }
}
