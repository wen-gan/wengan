package com.wengan.List;

import java.util.HashSet;

/**
 * @author 文淦
 * @version 1.0
 */
public class HashSet01 {
    public static void main(String[] args){
        HashSet set = new HashSet();
        //在执行add方法后会返回一个boolean值
        //如果添加成功则返回true，否则返回false
        System.out.println(set.add("john"));
        System.out.println(set.add("lucy"));
        System.out.println(set.add("john"));//加入不了
        System.out.println(set.add("jack"));
        System.out.println(set.add("Rose"));
        System.out.println("set = " + set);
        set.remove("john");
        System.out.println("set=" + set);

        set.add(new String("gan"));//ok
        set.add(new String("gan"));//不能加入
        System.out.println("set = " + set);
    }
}
