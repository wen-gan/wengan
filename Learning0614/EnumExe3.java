package com.wengan.Learning0614;

/**
 * @author 文淦
 * @version 1.0
 */
public class EnumExe3 {
    public static void main(String[] args){
        Week[] weeks = Week.values();
        System.out.println("===周===");
        for (Week week : weeks){
            System.out.println(week + "-->" + week.name());
        }
    }
}

enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WENSDAY("星期三"),THURSDAY("星期四"),
    FRIDAY("星期五"),SATURADAY("星期六"),SUNDAY("星期日");

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