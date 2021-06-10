package com.wengan.Learning0610;

/**
 * @author 文淦
 * @version 1.0
 */
public class Enum01 {
    public static void main(String[] args){

        System.out.println(Season.SPRING);
        System.out.println(Season.SUMMER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.WINTER);

    }
}

class Season{
    private String name;
    private String desc;//描述

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    //定义四个对象
    public static final Season SPRING = new Season("春天","温暖");
    public static final Season SUMMER = new Season("夏天","炎热");
    public static final Season AUTUMN = new Season("秋天","凉爽");
    public static final Season WINTER = new Season("冬天","寒冷");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return name + desc;
    }
}
