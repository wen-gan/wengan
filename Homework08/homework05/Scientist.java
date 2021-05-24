package com.wengan.Homework.homework05;

public class Scientist extends Staff{
    private double bonus;

    public Scientist(String name, double annual) {
        super(name, annual);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    //科学家有年终奖

    @Override
    public double printsalary() {
        System.out.print("科学家");
        return super.printsalary() + getBonus();
    }
}
