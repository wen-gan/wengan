package com.wengan.Homework.homework05;

public class Staff {
    private String name;
    private double annual;
    //分析出有一个带薪的月份
    public Staff(String name, double annual) {
        this.name = name;
        this.annual = annual;
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
    //打印工资
    public double printsalary(){
        return annual;
    }
}
