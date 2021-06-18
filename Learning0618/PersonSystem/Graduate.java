package com.wengan.Homework.PersonSystem;

/**
 * @author 文淦
 * @version 1.0
 */
public class Graduate extends Student{
    public Graduate(int age, String gender, int phone, String nativeplace, String xueli, String academic) {
        super(age, gender, phone, nativeplace, xueli, academic);
    }

    @Override
    public void studying() {
        System.out.println("发ei");
    }
}
