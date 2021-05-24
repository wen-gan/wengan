package com.wengan.Homework.homework04;

public class Genstaff extends Staff{
    public Genstaff(String name, double annual, int days) {
        super(name, annual, days);
    }

    @Override
    public String printsalary() {
        return super.printsalary() + "的工资为：" + (getAnnual()*getDays()*1.0);
    }
}
