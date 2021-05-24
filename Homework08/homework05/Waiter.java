package com.wengan.Homework.homework05;

public class Waiter extends Staff{
    public Waiter(String name, double annual) {
        super(name, annual);
    }

    @Override
    public double printsalary() {
        System.out.print("服务员");
        return super.printsalary();
    }
}
