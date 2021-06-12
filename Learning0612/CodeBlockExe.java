package com.wengan.Learning0612;

/**
 * @author 文淦
 * @version 1.0
 */
public class CodeBlockExe {
    public static void main(String[] args){
        Test a = new Test();

    }
}

class Test{
    Simple sam1 = new Simple("sam1成员初始化");//3
    static {
        Simple sam = new Simple("静态成员初始化");//1
        if(sam == null){
            System.out.println("sam is null");
        }
    }
    Test(){
        System.out.println("Test默认构造器被调用");//4
    }
}

class Simple{
    Simple(String s){
        System.out.println(s);//2
    }
    Simple(){
        System.out.println("Sample默认构造器被调用");
    }
}