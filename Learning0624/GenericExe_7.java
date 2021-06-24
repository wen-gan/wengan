package com.wengan.Learning0625;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericExe_7 {
    public static void main(String[] args){
        ArrayList<Empolyee> empolyees = new ArrayList<>();
        empolyees.add(new Empolyee("jack", 21200, new MyDate(1986,5,18)));
        empolyees.add(new Empolyee("smith", 35600, new MyDate(1986,5,28)));
        empolyees.add(new Empolyee("tom", 12500, new MyDate(1986,5,8)));

        Map hashMap = new HashMap();
        hashMap.put(1, new Empolyee("jack", 100, new MyDate(1999,12,13)));
        hashMap.put(2, new Empolyee("tom", 280, new MyDate(1989,12,19)));
        hashMap.put(3, new Empolyee("mike", 200, new MyDate(1969,10,2)));

        System.out.println("====排序前====");
        for (Empolyee empolyee : empolyees) {
            System.out.println(empolyee);
        }

        empolyees.sort(new Comparator<Empolyee>() {
            @Override
            public int compare(Empolyee emp1, Empolyee emp2) {
                if (!(emp1 instanceof Empolyee && emp2 instanceof Empolyee)){
                    return 0;
                }

                //比较名字
//                int nameValue = emp1.getName().compareTo(emp2.getName());
//                if (nameValue != 0){
//                    return nameValue;
//                }

                //比较薪水
//                double salValue = emp1.getSalary() - emp2.getSalary();
//                if (salValue > 0){
//                    return 1;
//                }else if (salValue < 0){
//                    return -1;
//                }else {
//                    return 0;
//                }

                //比较年龄
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println("====排序后====");
        for (Empolyee empolyee : empolyees) {
            System.out.println(empolyee);
        }

        //遍历map输出 entry
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        System.out.println("====用entry遍历输出====");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry key = (Map.Entry) next;
            System.out.println(key.getKey() + "--->" + key.getValue());
        }

        //用value输出
        Collection values = hashMap.values();
        System.out.println("====用value遍历输出====");
        for (Object empolyee : values) {
            System.out.println(empolyee);
        }

    }
}

class Empolyee{
    private String name;
    private double salary;
    private MyDate birthday;

    public Empolyee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Empolyee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
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

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
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
        int yearValue = year - o.getYear();
        if (yearValue != 0){
            return yearValue;
        }
        int monthValue = month - o.getMonth();
        if (monthValue != 0){
            return monthValue;
        }
        int dayValue = day - o.getDay();
        return dayValue;
    }
}