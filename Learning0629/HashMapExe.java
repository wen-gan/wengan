package com.wengan.Learning0629;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 文淦
 * @version 1.0
 */
public class HashMapExe {
    public static void main(String[] args){
        Map hashMap = new HashMap();

        hashMap.put(1, new Emp("jack", 12000, 1));
        hashMap.put(2, new Emp("tom", 16600, 1));
        hashMap.put(3, new Emp("mike", 20000, 1));

        //遍历输出
        Set keySet = hashMap.keySet();
        System.out.println("====使用keySet增强for循环遍历输出====");
        for (Object key : keySet) {
            Emp emp = (Emp) hashMap.get(key);
            if (emp.getSal() > 16000){
                System.out.println(emp);
            }
        }

        System.out.println("====使用entrySet迭代器循环遍历输出====");
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Emp emp = (Emp) entry.getValue();
            if (emp.getSal() > 16000) {
                System.out.println(emp);
            }
        }
    }
}


class Emp {
    private String name;
    private double sal;
    private int id;

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
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