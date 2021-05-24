package com.wengan.Homework.homework04;

public class Manager extends Staff{
    public Manager(String name, double annual, int days) {
        super(name, annual, days);
    }

    @Override
    public String printsalary() {
        return super.printsalary() + "的工资为：" + (1000+getAnnual()*getDays()*1.2);
    }
}
