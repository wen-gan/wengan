package com.wengan.Learning0611.Homework_Exception.generic_;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class Genric03 {
    public static void main(String[] args){
        Set<Student> set = new HashSet<Student>();
        set.add(new Student("john",12));
        set.add(new Student("tom",10));
        set.add(new Student("mary",11));
        for(Student student : set){
            System.out.println(student.getName() + "-" + student.getAge());
        }

        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()){
            //使用泛型后，快捷键会自动返回Student类型
            Student student = iterator.next();
            System.out.println(student);
        }

        HashMap<String, Student> gan = new HashMap<String, Student>();
        gan.put("tom",new Student("tom",22));

        //迭代器
        Set<Map.Entry<String, Student>> entries = gan.entrySet();
        Iterator<Map.Entry<String, Student>> iterator1 = entries.iterator();

        while (iterator.hasNext()){
            //Map.Entry<String, Student> next = iterator.next();
            //System.out.println(next.getKey() + "-" + next.getValue());
        }
    }
}

class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        super();
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
}