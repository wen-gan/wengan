package com.wengan.Homework.homework05;

public class Test {
    public static void main(String[] args){
        Staff jack = new Worker("jack", 1000);
        Staff mike = new Farmer("mike", 900);
        Staff tom = new Waiter("tom", 1500);
        Teacher kobe = new Teacher("kobe", 5000);
        //老师有课时费
        kobe.setDays(360);
        kobe.setAnnuals(1000);
        Scientist aidis = new Scientist("aidis", 50000);
        //科学家的年终奖需要确定
        aidis.setBonus(250000);
        System.out.println("jack的工资为"+jack.printsalary());
        System.out.println("mike的工资为"+mike.printsalary());
        System.out.println("tom的工资为"+tom.printsalary());
        System.out.println("kobe的工资为"+kobe.printsalary());
        System.out.println("aidis的工资为"+aidis.printsalary());
    }
}
