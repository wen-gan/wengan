package com.wengan.Learning0627;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ArrayExercise {
    public static void main(String[] args) {
        ArrayList<Empolyee> empolyees = new ArrayList<>();
        empolyees.add(new Empolyee("Jack", 2000, new MyDate(1999,8,9)));
        empolyees.add(new Empolyee("Jack", 6000, new MyDate(1999,11,24)));
        empolyees.add(new Empolyee("Jack", 4000, new MyDate(1999,8,12)));

        //遍历输出(迭代器)
        System.out.println("====排序前====");
        Iterator<Empolyee> iterator1 = empolyees.iterator();
        while (iterator1.hasNext()) {
            Empolyee empolyee = iterator1.next();
            System.out.println(empolyee);
        }

        empolyees.sort(new Comparator<Empolyee>() {
            @Override
            public int compare(Empolyee emp1, Empolyee emp2) {
                if (!(emp1 instanceof Empolyee && emp2 instanceof Empolyee)) {
                    return 0;
                }

                //判断名字
//                return emp1.getName().compareTo(emp2.getName());

                //按照薪水排序
//                double salValue = emp1.getSal() - emp2.getSal();
//                if (salValue > 0) {
//                    return 1;
//                }else if (salValue < 0) {
//                    return -1;
//                }else {
//                    return 0;
//                }

                //判断名字长度
                int nameValue = emp1.getName().length() - emp2.getName().length();
                if (nameValue != 0) {
                    return nameValue;
                }

                //按照生日 前后排序
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        //遍历输出(迭代器)
        System.out.println("====排序前====");
        Iterator<Empolyee> iterator2 = empolyees.iterator();
        while (iterator2.hasNext()) {
            Empolyee empolyee = iterator2.next();
            System.out.println(empolyee);
        }
    }
}

class Empolyee{
    private String name;
    private double sal;
    private MyDate birthday;

    public Empolyee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Empolyee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
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
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate o) {
        int yearValue = year - o.getYear();
        if (yearValue != 0) {
            return yearValue;
        }

        int monthValue = month - o.getMonth();
        if (monthValue != 0) {
            return monthValue;
        }

        int dayValue = day - o.getDay();
        return dayValue;
    }
}