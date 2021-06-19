package com.wengan.Learning0619;

/**
 * @author 文淦
 * @version 1.0
 */
public class EnumExe_5 {
    public static void main(String[] args){
        Week[] weeks = Week.values();
        for (Object week : weeks) {
            Week week1 = (Week) week;
            System.out.println(week1 + "---" + week1.name());
        }

    }
}

enum Week {
    MONDAY("星期一"), TUESDAY("星期二"), WENDESDAY("星期三"), THURSDAY("星期四"),
    FRIDAY("星期五"), SATURADAY("星期六"), SUNDAY("星期日");

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