package com.wengan.live;


public class Student extends Person {
        private String education;
        private String xueyuan;

    public Student(String name, String gender, int phonenum, String nativeplace, String hobby, String education, String xueyuan) {
        super(name, gender, phonenum, nativeplace, hobby);
        this.education = education;
        this.xueyuan = xueyuan;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(String xueyuan) {
        this.xueyuan = xueyuan;
    }

    //独有方法：上课
    public void studying(){
        System.out.println(getName()+"正在上课...");
    }
}
