package com.wengan.live0609;

public class Teacher extends Person implements Hobby,Comparable{
    //教师有职称、所属学院属性和授课的职能，
    private String rank;
    private String school;
    private double salary;

    public Teacher(int age, String gender, String tel, String address, String rank, String school, double salary) {
        super(age, gender, tel, address);
        this.rank = rank;
        this.school = school;
        this.salary = salary;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public void hobby() {
        System.out.println("爱踢足球");
    }

    @Override
    public int compareTo(Object o) {
        Teacher teacher = (Teacher)o;
        return (int)(this.salary - teacher.salary);
    }

}

interface Teaching{
    public void teach();
}