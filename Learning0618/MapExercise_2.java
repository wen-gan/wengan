package com.wengan.Map;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class MapExercise_2 {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put(1, new Empoly(1, "jack", 2000));
        map.put(2, new Empoly(2, "smith", 1000));
        map.put(3, new Empoly(3, "tom", 3000));

        //遍历输出 key
        Set keyset = map.keySet();
        System.out.println("---keyset增强for循环---");
        for (Object key : keyset) {
//            System.out.println(map.get(key));
            Empoly emp = (Empoly) map.get(key);
            if (emp.getSal() > 1800) {
                System.out.println(emp);
            }
        }

        System.out.println("---keyset迭代器循环---");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
//            System.out.println(map.get(key));
            Empoly empoly = (Empoly) map.get(key);
            if (empoly.getSal() < 1800) {
                System.out.println(empoly);
            }
        }

        //遍历输出value
        Collection values = map.values();
        System.out.println("---value增强for循环---");
        for (Object value : values) {
//            System.out.println(value);
            Empoly empoly = (Empoly) value;
            if (empoly.getSal() > 2000){
                System.out.println(empoly);
            }
        }

        System.out.println("---value迭代器循环---");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value = iterator1.next();
            Empoly empoly = (Empoly) value;
            if (empoly.getSal() < 2000) {
                System.out.println(empoly);
            }
        }

        //遍历输出 EntrySet
        Set entrySet = map.entrySet();
        System.out.println("---entrySet迭代器循环---");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator2.next();
            Empoly empoly = (Empoly) entry.getValue();
            if (empoly.getSal() > 1000) {
                System.out.println(empoly);
            }
        }

    }
}

class Empoly{
    private int id;
    private String name;
    private double sal;

    @Override
    public String toString() {
        return "员工姓名：" + name + "\t薪资：" + sal;
    }

    public Empoly(int id, String name, double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}