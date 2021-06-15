package com.wengan.Learning0615;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericExe4 {
    public static void main(String[] args){

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("mike", 2000, new MyDate(1999,2,15)));
        employees.add(new Employee("mike", 4500, new MyDate(1989,4,18)));
        employees.add(new Employee("mike", 8800, new MyDate(1978,7,14)));

        for (Employee employee : employees){
            System.out.println(employee);
        }
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //基本判断
                if (!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    return 0;
                }

                //判断薪水
//                double salValue = emp1.getSal() - emp2.getSal();
//                if (salValue > 0){
//                    return 1;
//                }else if (salValue < 0){
//                    return -1;
//                }else {
//                    return 0;
//                }

                //判断名字
                int nameValue = emp1.getName().compareTo(emp2.getName());
                if (nameValue != 0){
                    return nameValue;
                }

                //判断生日
                return emp1.getBirthday().compareTo(emp2.getBirthday());

            }
        });
        System.out.println("============================================");
        for (Employee employee : employees){
            System.out.println(employee);
        }
    }
}

class Employee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return name + "，" + sal + "，" + birthday;
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

    public void setBiirthday(MyDate birthday) {
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
    public String toString() {
        return "生日："+ year + "，" + month + "，" + day;
    }

    @Override
    public int compareTo(MyDate o) {
        //判断生日 年
        int yearValue = this.year - o.getYear();
        if (yearValue != 0){
            return yearValue;
        }

        //判断生日 月
        int monthValue = this.month - o.getMonth();
        if (monthValue != 0){
            return monthValue;
        }

        //判断生日 日
        int dayValue = this.day - o.getDay();
        return dayValue;
    }
}