package com.wengan.Learning0610.Homework12;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework05 {
    public static void main(String[] args){
        new A().test();

    }
}

class A{
    private String name = "睡觉";
    public void test(){
        class B{
            private final String NAME = "示范";
            public void show(){
                System.out.println("Name" + NAME + "\t" +"外部类的私有属性" + name);
            }
        }
        B b = new B();
        b.show();
    }

}