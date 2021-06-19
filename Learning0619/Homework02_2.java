package com.wengan.Learning0619;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02_2 {
    public static void main(String[] args){
        ArrayList arrayList = new ArrayList();

        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);
        Car car3 = new Car("沃尔沃", 6000000);
        Car car4 = new Car("奥拓", 20000);

        arrayList.add(car1);
        arrayList.add(car2);
        arrayList.add(car3);
        arrayList.add(car4);

        arrayList.remove(car1);

        System.out.println(arrayList.contains(car1));

        System.out.println(arrayList.isEmpty());

        System.out.println("遍历输出");
        for (Object arr : arrayList) {
            System.out.println(arr);
        }

        System.out.println("迭代器输出");
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Object arr = iterator.next();
            System.out.println(arr);
        }
    }
}

class Car {
    private String name;
    private double sal;

    @Override
    public String toString() {
        return "车名：" + name + "\t价格：" + sal + "\n";
    }

    public Car(String name, double sal) {
        this.name = name;
        this.sal = sal;
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
}