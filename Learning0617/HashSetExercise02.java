package com.wengan.Set;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author 文淦
 * @version 1.0
 */
public class HashSetExercise02 {
    public static void main(String[] args){
        HashSet employees = new HashSet();
        employees.add(new Employee1("jack", 2000, new MyDate(1999,12,13)));
        employees.add(new Employee1("john", 2000, new MyDate(1998,11,12)));
        employees.add(new Employee1("jack", 2000, new MyDate(1999,12,13)));

        for (Object emp : employees) {
            System.out.println(emp);
        }
    }
}

class Employee1{
    private String name;
    private double sal;
    private MyDate birthday;

    @Override
    public String toString() {
        return "名字：" + name + "\t\t薪资：" + "生日：" + birthday;
    }

    public Employee1(String name, double sal, MyDate birthday) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return Objects.equals(birthday, employee1.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday);
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    @Override
    public String toString() {
        return "年：" + year + "\t\t月：" + month + "\t\t日：" + day;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}