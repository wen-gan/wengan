package com.wengan.Learning0612;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;

/**
 * @author 文淦
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class GenericExercise {
    public static void main(String[] args){
        ArrayList<Employee> arrayList = new ArrayList<Employee>();
        arrayList.add(new Employee("jack",20000,new MyDate(1998,3,9)));
        arrayList.add(new Employee("jack",40000,new MyDate(1998,3,18)));
        arrayList.add(new Employee("jack",47000,new MyDate(1998,3,15)));
        System.out.println("==排序前==");
        for (Employee employee : arrayList){
            System.out.println(employee.getName()+","+employee.getSal()+","+employee.getBirthday().getYear()
                    +"年"+employee.getBirthday().getMonth()+"月"+employee.getBirthday().getDay()+"日");
        }
        arrayList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //初始判断
                if(!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    System.out.println("类型匹配错误");
                    return 0;
                }
                //比较名字
                int i = emp1.getName().compareTo(emp2.getName());
                if(i != 0){
                    return i;
                }
                //若名字相同则比较生日
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });
        System.out.println("==排序后==");
        for (Employee employee : arrayList){
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
        return "名字："+name+","+"薪资："+sal+","+"生日："+birthday;
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
        //首先比较生日里的年
        int yearCompare = this.year - o.getYear();
        if (yearCompare != 0){
            return yearCompare;
        }
        //年相同就比较生日里的月
        int monthCompare = this.month - o.getMonth();
        if (monthCompare != 0){
            return monthCompare;
        }
        //月相同就比较生日里的日
        int dayCompare = this.day - o.getDay();
        return dayCompare;
    }
}