package com.wengan.live0609;

public class Doctor extends Teacher implements Teaching,Hobby{

    public Doctor(int age, String gender, String tel, String address, String rank, String school, double salary) {
        super(age, gender, tel, address, rank, school, salary);
    }

    @Override
    public void teach() {
        System.out.println("教授专注于科研");
    }
}
