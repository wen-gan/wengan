package com.wengan.Learning0610;

/**
 * @author 文淦
 * @version 1.0
 */
public class EnumMethod {
    public static void main(String[] args){
        Season2 autumn = Season2.AUTUMN;
        System.out.println(autumn.name());//直接返回该对象的变量名
        System.out.println(autumn.ordinal());//输出该常量对象的次序(编号)
        //values返回的是Season2[],含有所有的枚举对象
        Season2[] values = Season2.values();
        //增强for循环,依次从values数组中取出数赋给season2
        //如果取值完毕就退出for循环
        for (Season2 season2: values) {
            System.out.println(season2);
        }
        //valueOf将字符串转换成枚举对象，要求字符串必须为已有的常量名，否则报告异常
        Season2 autumn2 = Season2.valueOf("AUTUMN");
        System.out.println("autumn" + autumn2);

        //compareTo 比较两个枚举常量，比较的是编号
        //Season2.AUTUMN的编号 - Season2.SUMMER的编号
        System.out.println(Season2.AUTUMN.compareTo(Season2.SUMMER));
    }

}
