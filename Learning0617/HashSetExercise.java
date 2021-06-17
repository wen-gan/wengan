package com.wengan.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class HashSetExercise {
    public static void main(String[] args){
        Set set = new HashSet();
        set.add(new Employee("jack", 21));//ok
        set.add(new Employee("john", 22));//ok
        //加不进去（重写了equals和hashcode方法）
        set.add(new Employee("jack", 21));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }

    }
}

class Employee{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "员工姓名：" + name + "\t\t年龄：" + age;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //如果name 和 age相同，则返回相同的hash值

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}