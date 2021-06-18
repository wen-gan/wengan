package com.wengan.Homework.PersonSystem;

/**
 * @author 文淦
 * @version 1.0
 */
public class Person {
    /*
       所有的人员具有相同属性：年龄、性别、电话、籍贯；相同的爱好：运动。
     */

    private int age;
    private String gender;
    private int phone;
    private String nativeplace;

    public Person(int age, String gender, int phone, String nativeplace) {
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.nativeplace = nativeplace;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhpne(int phone) {
        this.phone = phone;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String hobby() {
        return "爱运动";
    }
}

