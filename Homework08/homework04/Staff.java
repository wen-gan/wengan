package com.wengan.Homework.homework04;

public class Staff {
    private String name;
    private double annual;
    private int days;

    public Staff(String name, double annual, int days) {
        this.name = name;
        this.annual = annual;
        this.days = days;
    }

    //员工方法
    public String printsalary(){
        return getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnnual() {
        return annual;
    }

    public void setAnnual(double annual) {
        this.annual = annual;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
