package com.wengan.Homework.homework05;

public class Farmer extends Staff{
    public Farmer(String name, double annual) {
        super(name, annual);
    }

    @Override
    public double printsalary() {
        System.out.print("农民");
        return super.printsalary();
    }
}
