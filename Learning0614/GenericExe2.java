package com.wengan.Learning0614;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericExe2 {
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jack", 2000, new MyDate(1998, 3, 6)));
        employees.add(new Employee("jack", 4000, new MyDate(1998, 3, 8)));
        employees.add(new Employee("jack", 3000, new MyDate(1998, 3, 7)));

        System.out.println("==排序前==");
        for (Employee employee : employees){
            System.out.println(employee.getName()+","+employee.getSal()+","+employee.getBirthday().getYear()
                    +"年"+employee.getBirthday().getMonth()+"月"+employee.getBirthday().getDay()+"日");
        }
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //基本判断
                if(!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    System.out.println("类型匹配错误");
                    return 0;
                }

                //先按照名字长度排序
                int nameLength = emp1.getName().compareTo(emp2.getName());
                if( nameLength != 0){
                    return nameLength;
                }

                //按照生日日期的先后排序
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println("==排序后==");
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
        return "该员工的名字为：" + name + "，薪资为：" + sal + "生日为：" + birthday;
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
        //首先判断年
        int yearValue = this.year - o.getYear();
        if(yearValue != 0){
            return yearValue;
        }
        //年相同则判断月
        int monthValue = this.month - o.getMonth();
        if(monthValue != 0){
            return monthValue;
        }
        //月相同则判断日
        int dayValue = this.day - o.getDay();
        return dayValue;


    }
}