package com.wengan.Homework.homework03;

public class homework03 {
    public static void main(String[] args){
        Teacher jack = new Professor("jack", 67, "高级", 30000.0,1.3);
        jack.introduce();
        Teacher mike = new Assprofessor("mike", 63, "中级", 20000.0,1.2);
        mike.introduce();
        Teacher tom = new Professor("tom", 60, "初级", 10000.0,1.1);
        tom.introduce();
    }
}
