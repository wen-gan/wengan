package com.wengan.live0609;

public class General extends Student implements Studying,Hobby{

    public General(int age, String gender, String tel, String address, String rank, String school) {
        super(age, gender, tel, address, rank, school);
    }

    @Override
    public void study() {
        System.out.println("本科生专注于写毕设");
    }
}
