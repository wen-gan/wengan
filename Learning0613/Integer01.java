package com.wengan.Learning0612;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})

public class Integer01 {
    public static void main(String[] args){
        //int 和 integer 的装箱和拆箱
        //手动装箱 int - integer
        int n1 = 100;
        Integer integer = new Integer(n1);
        Integer integer1 = Integer.valueOf(n1);

        //手动拆箱
        //integer - int
        int i = integer.intValue();

        //jdk5后就可以自动装箱和自动拆箱
        int n2 = 100;
        double d1 = 100.1;

        //自动装箱
        Integer integer2 = n2;//底层使用的是 Integer.valueOf(n1)方法
        Double d2 = d1;
        //自动拆箱
        int n3 = integer2;//底层使用是是 integer.intValue()
        double d3 = d2;

    }
}

