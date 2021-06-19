package com.wengan.Learning0619;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericExe_6 {
    public static void main(String[] args){
        ArrayList<Empolyee> empolyees = new ArrayList<>();
        empolyees.add(new Empolyee("jack", 6000, new MyDate(1988,3,7)));
        empolyees.add(new Empolyee("tom", 1500, new MyDate(1988,3,1)));
        empolyees.add(new Empolyee("smith", 2000, new MyDate(1988,3,17)));
        System.out.println("====直接输出====");
        Iterator<Empolyee> iterator = empolyees.iterator();
        while (iterator.hasNext()) {
            Empolyee empolyee = iterator.next();
            System.out.println(empolyee);
        }

        empolyees.sort(new Comparator<Empolyee>() {
            @Override
            public int compare(Empolyee emp1, Empolyee emp2) {
                //初始化检查
                if (!(emp1 instanceof Empolyee && emp2 instanceof Empolyee)) {
                    return 0;
                }

                //按照名字长度排列
                //return emp1.getName().length() - emp2.getName().length();
//                int nameValue = emp1.getName().compareTo(emp2.getName());
////                if (nameValue != 0) {
////                    return nameValue;
////                }

                //按照薪水多少排列
//                double salValue = emp1.getSalary() - emp2.getSalary();
//                if (salValue > 0) {
//                    return 1;
//                }else if (salValue < 0) {
//                    return -1;
//                }else {
//                    return 0;
//                }

                //按照生日排列
                return emp1.getBirthday().compareTo(emp2.getBirthday());

            }
        });

        //迭代器循环遍历输出
        System.out.println("====迭代器循环输出====");
        Iterator<Empolyee> iterator1 = empolyees.iterator();
        while (iterator1.hasNext()) {
            Empolyee empolyee = iterator1.next();
            System.out.println(empolyee);
        }

    }
}

class Empolyee{
    private String name;
    private double salary;
    private MyDate birthday;

    @Override
    public String toString() {
        return "员工姓名：" + name + "\t薪资：" + salary + "\t生日：" + birthday;
    }

    public Empolyee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        return "年：" + year + "\t月：" + month + "\t日：" + day;
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
    public int compareTo(MyDate o) {
        int yearValue = this.getYear() - o.year;
        if (yearValue != 0) {
            return yearValue;
        }

        int monthValue = this.getMonth() - o.month;
        if (monthValue != 0) {
            return monthValue;
        }

        int dayValue = this.getDay() - o.day;
        return dayValue;
    }
}