package com.wengan.extend.exercise;

public class ExtendsExercise01 {
    public static void main(String[] args){
        B b = new B();
    }
}

class A{
    A(){
        System.out.println("a");
    }
    A(String name){
        System.out.println("a name");
    }
}
class B extends A{
    B(){
        this("abc");
        System.out.println("b");
    }
    B(String name){
        //默认会调用父类构造器的无参构造器super()
        System.out.println("b name");
    }
}