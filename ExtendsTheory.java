package com.wengan.extend;
/*
继承的本质
 */
public class ExtendsTheory {
    public static void main(String[] args){
        Son son = new Son();
        //(1)首先看子类的属性，是否有该属性
        //(2)如果子类有这个属性并且可以访问，则返回信息
        //(3)如果子类没有这个属性，就看父类有没有这个属性（如果父类有且可以访问，就返回信息）
        //(4)如果父类没有就按照(3)的规则，继续写找上级父类
        System.out.println(son.name);
        //此时要按照查找关系返回信息,这里返回儿子
        System.out.println(son.getAge());
        //返回父类的age=39
        System.out.println(son.hobby);
        //返回爷爷类的hobby=旅游
    }
}

class GrandPa{
    String name = "爷爷";
    String hobby = "旅游";
}
class Father extends GrandPa {
    String name = "爸爸";
    private int age = 39;

    public int getAge() {
        return age;
    }
}
class Son extends Father{
    String name = "儿子";
}