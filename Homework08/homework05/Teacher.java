package com.wengan.Homework.homework05;

public class Teacher extends Staff{
    private int days;
    private double annuals;

    public Teacher(String name, double annual) {
        super(name, annual);

    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getAnnuals() {
        return annuals;
    }

    public void setAnnuals(double annuals) {
        this.annuals = annuals;
    }

    //教师的工资还有课酬
    @Override
    public double printsalary() {
        System.out.print("老师");
        return super.printsalary() + getAnnuals()*getDays();
    }
}
