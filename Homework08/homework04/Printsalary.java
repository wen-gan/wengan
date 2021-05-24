package com.wengan.Homework.homework04;

import java.util.Scanner;

public class Printsalary {
    public static void main(String[] args){
        Scanner myscanner = new Scanner(System.in);
        //普通员工
        System.out.println("请输入普通员工单日工资");
        double annual1 = myscanner.nextDouble();
        System.out.println("请输入普通员工工作天数");
        int day1 = myscanner.nextInt();
        Staff jack = new Genstaff("jack", annual1, day1);
        System.out.println(jack.printsalary());
        System.out.println("============================");
        //部门经理
        System.out.println("请输入部门经理单日工资");
        double annual2 = myscanner.nextDouble();
        System.out.println("请输入部门经理工作天数");
        int day2 = myscanner.nextInt();
        Staff mike = new Manager("mike", annual2, day2);
        System.out.println(mike.printsalary());
    }
}
