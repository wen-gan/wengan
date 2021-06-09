package com.wengan.live0609;

public class Lecturer extends Teacher implements Teaching,Hobby{

    public Lecturer(int age, String gender, String tel, String address, String rank, String school, double salary) {
        super(age, gender, tel, address, rank, school, salary);
    }

    @Override
    public void teach() {
        System.out.println("讲师专注于教书上课");
    }
}
