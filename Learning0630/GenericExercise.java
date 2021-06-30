package com.wengan.Learning0630;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class GenericExercise {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("jack", 18));
        students.add(new Student("ton", 29));
        students.add(new Student("mary", 19));

        for (Student student : students) {
            System.out.println(student);
        }

        HashMap<String, Student> hm = new HashMap<>();
        hm.put("mike", new Student("mike", 18));
        hm.put("jazz", new Student("jazz", 48));
        hm.put("lakers", new Student("lakers", 58));

        //迭代器输出
        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        System.out.println("====遍历输出====");
        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + "----" + next.getValue());
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
}