package com.wengan.Learning0612;

import java.util.ArrayList;

/**
 * @author 文淦
 * @version 1.0
 */
public class CustominterfaceGeneric {
    public static void main(String[] args){

        //T ---> String, R ---> Arraylist
        Fish<String, ArrayList> fish = new Fish<>();
        fish.hello(new ArrayList(),11.3f);
    }
}

interface IUsb<U, R>{
    //在普通方法中，可以使用接口泛型
    R get(U u);

    void h1(R r);

    void run(R r1, R r2, U u1, U u2);

    //在JDK8中，可以在接口中使用默认方法,也可以使用泛型
    default R method(U u){
        return null;
    }
}

class Fish<T, R>{//泛型类
    public void run(){//普通方法
    }
    public<U, M> void eat(U u,M m){
        //泛型方法
    }

    //下面的hi方法不是泛型方法
    //是hi方法使用了类声明的泛型
    public void hi(T t){

    }
    //泛型方法，可以使用类声明的泛型，也可以使用自己声明的泛型
    public<K> void hello(R r, K k){
        System.out.println(r.getClass());
        System.out.println(k.getClass());
    }
}