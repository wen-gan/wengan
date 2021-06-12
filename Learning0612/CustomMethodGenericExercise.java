package com.wengan.Learning0612;

/**
 * @author 文淦
 * @version 1.0
 */
public class CustomMethodGenericExercise {
    public static void main(String[] args){
        Apple<String, Integer, Double> apple = new Apple<>();
        apple.fly(10);
        apple.fly(new Dog1());
    }
}

class Apple<T,R,M>{
    public<E> void  fly(E e){
        System.out.println(e.getClass().getSimpleName());
    }
    public void eat(T t){}
    public void run(M m){}
}

class Dog1{

}