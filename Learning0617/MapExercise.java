package com.wengan.Map;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class MapExercise {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put(1, new Emp("jack", 10000, 1));
        map.put(2, new Emp("john", 12000, 2));
        map.put(3, new Emp("mike", 23000, 3));

        //运用key方法遍历
        Set keyset = map.keySet();
        System.out.println("------增强for------");
        for (Object key : keyset) {
            System.out.println(key + "-" + map.get(key));
            //先获取value
            Emp emp = (Emp) map.get(key);
            if (emp.getSal() > 18000) {
                System.out.println(emp);
            }
        }


        System.out.println("------迭代器迭代------");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj + "-" + map.get(obj));
        }

        //运用value
        Collection values = map.values();
        System.out.println("------增强for(value)------");
        for (Object value : values) {
            System.out.println(value);
        }

        System.out.println("------迭代器迭代------");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            System.out.println(value);
        }

        //运用EntrySet 来获取k - v
        Set entrySet = map.entrySet();
        System.out.println("------增强for(value)------");
        for (Object entry : entrySet) {
            //将entry 转成 Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }

        System.out.println("------迭代器迭代------");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry = iterator2.next();
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}

class Emp {
    private String name;
    private double sal;
    private int id;

    @Override
    public String toString() {
        return id + "姓名：" + name + "薪资：" + sal;
    }

    public Emp(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}