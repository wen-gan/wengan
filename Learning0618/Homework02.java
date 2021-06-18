package com.wengan.Homework;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        Car car1 = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 5000000);
        Car car3 = new Car("沃尔沃", 6000000);
        Car car4 = new Car("奥拓", 20000);

        arrayList.add(car1);
        arrayList.add(car2);
        arrayList.add(car3);
        arrayList.add(car4);
        //直接输出
        System.out.println("---直接输出---");
        System.out.println(arrayList);

        //删除指定元素
        arrayList.remove(car4);
        System.out.println("---删除---");
        System.out.println(arrayList);

        //查找元素是否存在
        System.out.println("---查找---");
        System.out.println(arrayList.contains(car3));

        //获取元素个数
        int counts = arrayList.size();
        System.out.println("数组长度 =" + counts);

        //判断是否为空
        boolean b = arrayList.isEmpty();
        System.out.println(b);

        //清空
//        arrayList.clear();
//        System.out.println(arrayList);

        //添加多个元素
//        arrayList.addAll(arrayList);

        //查找多个元素
        System.out.println(arrayList.containsAll(arrayList));

        //删除多个元素
        arrayList.removeAll(arrayList);


        //遍历输出
        System.out.println("===增强for循环遍历输出===");
        for (Object arr : arrayList) {
            System.out.println(arr);
        }

        //迭代器
        System.out.println("===迭代器遍历输出===");
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