package com.wengan.abstract_;

public class TestTemplate {
    public static void main(String[] args) {

        com.wengan.abstract_.AA aa = new com.wengan.abstract_.AA();
        aa.calculateTime(); //这里还是需要有良好的OOP基础，对多态

        com.wengan.abstract_.BB bb = new com.wengan.abstract_.BB();
        bb.calculateTime();
    }
}
