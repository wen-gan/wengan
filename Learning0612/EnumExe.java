package com.wengan.Learning0612;

/**
 * @author 文淦
 * @version 1.0
 */
public class EnumExe {
    public static void main(String[] args){
        Week[] weeks = Week.values();
        //System.out.println(Week.MONDAY.toString());
        System.out.println("===一周都有===");
        for (Week week : weeks){
            System.out.println(week.name() + "---->" + week);
        }
    }
}

enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THURSDAY("星期四")
    ,FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期日");

    private String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}