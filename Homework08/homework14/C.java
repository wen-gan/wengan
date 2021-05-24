package com.wengan.Homework.homework14;

public class C extends B{
    public C(){
        this("hello");
        System.out.println("我是C类无参构造器");
    }
    public C(String name){
        super("hahaha");
        System.out.println("我是C类有参构造器");
    }
}
