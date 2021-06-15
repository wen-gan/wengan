package com.wengan.Learning0614;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class GenericExe3 {
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack",4500,new MyDate(1998,12,14)));
        employees.add(new Employee("jack",7200,new MyDate(1998,10,14)));
        employees.add(new Employee("jack",6500,new MyDate(1998,8,14)));

        System.out.println("====排序前====");
        for (Employee employee : employees){
            System.out.println(employee.getName()+","+employee.getSal()+","+employee.getBirthday().getYear()
                    +"年"+employee.getBirthday().getMonth()+"月"+employee.getBirthday().getDay()+"日");
        }
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //初始判断
                if (!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    System.out.println("类型匹配错误");
                    return 0;
                }

                //先比较名字
                int nameL = emp1.getName().compareTo(emp2.getName());
                if (nameL != 0){
                    return nameL;
                }

                //名字相同则比较生日
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });
        System.out.println("====排序后=====");
        for (Employee employee : employees){
            System.out.println(employee.getName()+","+employee.getSal()+","+employee.getBirthday().getYear()
                    +"年"+employee.getBirthday().getMonth()+"月"+employee.getBirthday().getDay()+"日");
        }
    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    @Override
    public String toString() {
        return "员工姓名：" + name + " 薪资：" + sal + " 生日：" + birthday;
    }

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
}

class MyDate implements Comparable<MyDate>{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(MyDate o) {
        //先比较生日里的 年
        int yearValue = this.year - o.year;
        if (yearValue != 0){
            return yearValue;
        }
        //年相同则比较 月
        int monthValue = this.month - o.month;
        if (monthValue != 0){
            return monthValue;
        }
        //月相同则比较 日
        int dayValue = this.day - o.day;
        return dayValue;
    }
}