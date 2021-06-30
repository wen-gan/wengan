package com.wengan.Learning0630;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class MapExercise {
    public static void main(String[] args) {
        Map m = new HashMap();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);

        //遍历输出
        System.out.println("====直接输出(原始)====");
        Set keySet = m.keySet();
        for (Object key : keySet) {
            System.out.println(key + "---" + m.get(key));
        }

        System.out.println("====将jack的工资更改为2600元====");
        m.put("jack", 2600);
        for (Object key : keySet) {
            System.out.println(key + "---" + m.get(key));
        }

        System.out.println("====所有员工工资加薪100元====");
        for (Object key : keySet) {
            m.put(key, (Integer)(m.get(key)) + 100);
            System.out.println(key + "---" + m.get(key));
        }

        System.out.println("====遍历所有的员工====");
        for (Object key : keySet) {
            System.out.println(key);
        }

        System.out.println("====遍历所有的工资====");
        Collection values = m.values();
        for (Object value : values) {
            System.out.println(value);
        }

        System.out.println("====entrySet====");
        Set entrySet = m.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Map.Entry key = (Map.Entry) next;
            System.out.println(key.getKey() + "---" + key.getValue());
        }

    }
}

class Empolyee {
    private String name;
    private double salary;

    @Override
    public String toString() {
        return "Empolyee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Empolyee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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
}