package com.wengan.Learning0629;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {
        //使用默认的构造器，创建TreeMap, 是无序的(也没有排序)
        /*
            按照传入的 k(String) 的大小进行排序
         */
//        TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照传入的 k(String) 的大小进行排序
                //按照K(String) 的长度大小排序
                //return ((String) o2).compareTo((String) o1);
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "斯密斯");
        treeMap.put("hsp", "韩顺平");//加入不了
        treeMap.put("mike", "麦克");//加入不了

        System.out.println("treemap=" + treeMap);

    }
}
