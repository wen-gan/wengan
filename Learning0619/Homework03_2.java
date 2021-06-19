package com.wengan.Learning0619;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework03_2 {
    public static void main(String[] args){
        HashMap hashMap = new HashMap();
        hashMap.put("jack", 650);
        hashMap.put("tom", 1200);
        hashMap.put("smith", 2900);
        System.out.println(hashMap);

        System.out.println("修改jack的工资为2600");
        hashMap.put("jack", 2600);
        System.out.println(hashMap);

        //使用entrySet遍历输出
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

        //每个人的工资加100
        Set keySet = hashMap.keySet();
        for (Object key : keySet) {
            hashMap.put(key, (Integer)hashMap.get(key) + 100);
            System.out.println(key + "---" + hashMap.get(key));
        }

    }
}
