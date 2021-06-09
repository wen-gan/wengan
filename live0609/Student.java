package com.wengan.live0609;

public class Student extends Person implements Hobby{
    //学生有学历、所属学院属性和上课的职能，
    //学生(本科、硕士、博士)
    private String rank;
    private String school;

    public Student(int age, String gender, String tel, String address, String rank, String school) {
        super(age, gender, tel, address);
        this.rank = rank;
        this.school = school;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void hobby() {
        System.out.println("爱打篮球");
    }
}

interface Studying{
    public void study();
}