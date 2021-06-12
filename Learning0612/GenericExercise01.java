package com.wengan.Learning0612;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * @author 文淦
 * @version 1.0
 */

public class GenericExercise01 {
    public static void main(String[] args){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("tom",20000,new MyDate(3,12,1999)));
        employees.add(new Employee("tom",30000,new MyDate(3,7, 1999)));
        employees.add(new Employee("tom",40000,new MyDate(3,29,1999)));
        System.out.println("===排序前===");
        System.out.println(employees);
//        for (Employee employee : employees){
//            System.out.println(employee.getName());
//        }

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee emp1, Employee emp2) {
                //按照name排序，若name相同则按照生日日期先后排序[定制排序]
                //首先对传入的参数进行排序
                if(!(emp1 instanceof Employee && emp2 instanceof Employee)){
                    System.out.println("类型不匹配");
                    return 0;
                }
                //比较名字
                int i = emp1.getName().compareTo(emp2.getName());
                if(i != 0){
                    return i;
                }
                //如果name相同，就比较 birthday - year
                //下面是对birthday的比较，因此可以把这个比较放在MyDate类里面进行
                return emp1.getBirthday().compareTo(emp2.getBirthday());
            }
        });

        System.out.println("==对雇员进行排序==");
        System.out.println(employees);
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
        return "\n"+"该员工的名字为："+name+",薪资为："+sal+"生日为："+birthday;
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
    private int month;
    private int day;
    private int year;

    public MyDate(int month, int day, int year) {
        this.month = month;
        this.day = day;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\n"+"生日为："+year+"年"+month+"月"+day+"日";
    }

    @Override
    public int compareTo(MyDate o) {
        //把对年月日的比较放在这里
        int yearMinus = this.year - o.getYear();
        if(yearMinus != 0){
            return yearMinus;
        }
        //如果年相同就比较月
        int monthMinus = this.month - o.getMonth();
        if(monthMinus != 0){
            return monthMinus;
        }
        //如果月相同就比较日
        int dayMinus = this.day - o.getDay();
        return dayMinus;
    }
}
