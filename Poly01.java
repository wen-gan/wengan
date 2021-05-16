package com.wengan.poly_;

public class Poly01 {
    public static void main(String[] args){
        Master tom = new Master("tom");
        Dog mike = new Dog("mike");
        Bone bone = new Bone("大棒骨");

        tom.feed(mike, bone);

        Cat jenne = new Cat("jenne");
        Fish fish = new Fish("黄花鱼");
        System.out.println("================");
        tom.feed(jenne, fish);
    }
}
