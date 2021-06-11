package com.wengan.Learning0611.Homework_Exception.generic_;

/**
 * @author 文淦
 * @version 1.0
 */
public class CustomGeneric_ {
    public static void main(String[] args){

        //T = Double, R = String, M = Integer
        Tiger<Double, String, Integer> g = new Tiger<>("john");
        g.setT(10.9);//正确
        //g.setT("sss");//错误
        System.out.println(g);//正确

        Tiger g2 = new Tiger("jack");//正确，默认T=Object,R=Object,M=Object
        g2.setT("yy");//正确。因为g2对象的T是Object
        System.out.println("g2 = "+g2);
    }
}

//Tiger为自定义泛型
//T, R, M为泛型的标识符
//泛型的标识符可以有多个
//普通成员可以使用泛型(属性、方法)
//静态方法不能使用泛型(因为静态是和类相关的，在类加载时，对象还没有创建)
//使用泛型的数组不能初始化
//泛型类的类型是在创建对象时确定的(因为创建对象时，需要制定确定类型)
//如果在创建对象时，没有指定类型，默认为Object
class Tiger<T, R, M>{
    String name;
    R r;//属性使用到泛型
    M m;
    T t;

    public Tiger(String name){
        this.name = name;
    }

    public Tiger(T t, R r, M m) {//构造器使用到泛型
        this.r = r;
        this.m = m;
        this.t = t;
    }

    public String getName() {//方法使用到泛型
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public M getM() {
        return m;
    }

    public void setM(M m) {
        this.m = m;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}