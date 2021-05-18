package com.wengan.live;


public class Teacher extends Person {
    private String title;
    private String xueyuan;

    public Teacher(String name, String gender, int phonenum, String nativeplace, String hobby, String title, String xueyuan) {
        super(name, gender, phonenum, nativeplace, hobby);
        this.title = title;
        this.xueyuan = xueyuan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXueyuan() {
        return xueyuan;
    }

    public void setXueyuan(String xueyuan) {
        this.xueyuan = xueyuan;
    }
    //授课方法
    public void teach(){
        System.out.println(getName()+"正在授课...");
    }
}
