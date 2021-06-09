package com.wengan.live0609;

public class Person implements Hobby{
    /*
        需要编写一个北交大的人员管理系统，
        管理的人员包括：学生(本科、硕士、博士)、教师（讲师、教授）、后勤人员（宿管和保安）。
        所有的人员具有相同属性：年龄、性别、电话、籍贯；相同的爱好：运动。

        不同类的人员含有不同的属性和职能，
        学生有学历、所属学院属性和上课的职能，
        教师有职称、所属学院属性和授课的职能，
        后勤人员有编制属性(在编和非在编)和后勤保障的职能。

        同一类人的不同细分也具有不同的属性或职能，
        举例：1.本科生需要写毕设、硕士需要发 ei，博士需要发 sci；
        2.讲师专注于上课，教授专注于科研；
        3.宿管需要查寝，保安需要巡逻
     */
    private int age;
    private String gender;
    private String tel;
    private String address;

    public Person(int age, String gender, String tel, String address) {
        this.age = age;
        this.gender = gender;
        this.tel = tel;
        this.address = address;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void hobby() {
        System.out.println("爱好的运动是：");
    }
}

interface Hobby{
    public void hobby();
}