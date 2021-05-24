package com.wengan.Homework.homework05;

public class Worker extends Staff{
    public Worker(String name, double annual) {
        super(name, annual);
    }

    @Override
    public double printsalary() {
        System.out.print("工人");
        return super.printsalary();
    }
}
