package com.wengan.Learning0610.Homework12;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework04 {
    public static void main(String[] args){

        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 + n2;
            }
        },10,20);
    }
}

interface Calculate{
    public double work(double n1,double n2);
}

class Cellphone{
    public void testWork(Calculate calculate, double n1, double n2){
        double result = calculate.work(n1,n2);
        System.out.println("计算后的结果是：" + result);
    }

}
