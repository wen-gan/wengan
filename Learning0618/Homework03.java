package com.wengan.Homework;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03 {
    public static void main(String[] args) {
        Map hashMap = new HashMap<String, Integer>();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        System.out.println(hashMap);

        System.out.println("修改jack的工资为2600");
        hashMap.put("jack", 2600);
        System.out.println(hashMap);

        //遍历输出
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        System.out.println("===entry循环遍历输出===");
        while (iterator.hasNext()) {
            Object entry = iterator.next();
            Map.Entry en = (Map.Entry) entry;
            System.out.println(en.getKey() + "-" + en.getValue());
        }

        //所有员工加薪100元
        Set keySet = hashMap.keySet();
        System.out.println("===加薪100元===");
        for (Object key : keySet) {
            hashMap.put(key, (Integer)hashMap.get(key) + 100);
            System.out.println(key + "-" + hashMap.get(key));
        }

        System.out.println("===value遍历输出===");
        Collection values = hashMap.values();
        for (Object value : values) {
            System.out.println(value);
        }


    }
}
