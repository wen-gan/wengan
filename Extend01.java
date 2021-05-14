package com.wengan.extend.improve_;

public class Extend01 {
    public static void main(String[] args){
        Pupil pupil = new Pupil();
        pupil.setScore(20);
        pupil.name= "jack-";
        pupil.age = 10;
        pupil.testing();
        pupil.showInfo();

        System.out.println("==============");
        Graduate graduate = new Graduate();
        graduate.setScore(80);
        graduate.name = "smith-";
        graduate.age = 26;
        graduate.testing();
        graduate.showInfo();
    }
}
