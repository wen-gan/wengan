package com.wengan.Learning0610;
/**
 * @author 文淦
 * @version 1.0
 */
public class Enumexercise02 {
    public static void main(String[] args){
//        Week1[] weeks = new Week1[7];
//        System.out.println("===所有星期的信息如下===");
//        System.out.println(Week1.MONDAY);
//        System.out.println(Week1.TUESDAY);
//        System.out.println(Week1.WEDSDAY);
//        System.out.println(Week1.TUESDAY);
//        System.out.println(Week1.FRIDAY);
//        System.out.println(Week1.SATURADAY);
//        System.out.println(Week1.SUNDAY);

        Week1[] weeks = Week1.values();
        System.out.println("===所有星期的信息如下===");
        for(Week1 week : weeks){
            System.out.println(week);
        }
    }
}

enum Week1{
    MONDAY("星期一"),TUESDAY("星期二"),WEDSDAY("星期三"),THURSDAY("星期四"),
    FRIDAY("星期五"),SATURADAY("星期六"),SUNDAY("星期日");

    private String name;

    private Week1(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}