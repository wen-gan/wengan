package com.wengan.Learning0610.Homework12;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework07 {
    public static void main(String[] args){

        Car car = new Car(50);
        car.getAir().flow();
    }
}

class Car{
    private double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }
    class Air{
        public void flow(){
            System.out.println("吹风");
            if(temperature >= 40){
                System.out.println("吹冷气");
            }else if(temperature <= 0){
                System.out.println("吹暖气");
            }else {
                System.out.println("关闭空调");
            }
        }

    }
    public Air getAir(){
        return new Air();
    }
}