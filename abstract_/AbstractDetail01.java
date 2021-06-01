package com.wengan.abstract_;

public class AbstractDetail01 {
    public static void main(String[] args) {
    }
}

abstract class A {
    public void hi() {
        System.out.println("hi");
    }
}

abstract class B {
    public abstract void hi();
}
//abstract 只能修饰类和方法，不能修饰属性和其它的
class C {
   // public abstract int n1 = 1;
}

