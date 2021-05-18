package com.wengan.live;

public class test {
    public static void main(String[] args){
        Student jack = new Undergraduate("jack", "男", 1233,
                "四川", "运动", "本科", "交运");
        jack.studying();

        HouQin mike = new HouseMaster("mike", "男", 456, "Beijing",
                "dancing", "zaibian", "fou");
        mike.protect();

        Teacher jone = new Lecturer("jone", "女", 789, "陕西", "singing",
                "higher", "交运");
        jone.teach();
    }
}

class Person{
    private String name;
    private String gender;
    private int phonenum;
    private String nativeplace;
    private String hobby;

    public Person(String name, String gender, int phonenum, String nativeplace, String hobby) {
        this.name = name;
        this.gender = gender;
        this.phonenum = phonenum;
        this.nativeplace = nativeplace;
        this.hobby = hobby;
    }

    public void hobby(){
        System.out.println(name + "的爱好是" + hobby);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(int phonenum) {
        this.phonenum = phonenum;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
