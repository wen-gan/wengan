package com.wengan.Learning0615;

/**
 * @author 文淦
 * @version 1.0
 */
public class EnumExe4 {
    public static void main(String[] args){
        Week[] weeks = Week.values();
        for (Week week : weeks){
            System.out.println(week + "--->" + week.name());
        }

    }
}

enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WENDESDAY("星期三"),THURESDAY("星期四")
    ,FRIDAY("星期五"),SATURADAY("星期六"),SUNDAY("星期日");

    @Override
    public String toString() {
        return name;
    }

    private String name;

    Week(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}