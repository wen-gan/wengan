package com.wengan.Learning0620;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework03_3 {
    public static void main(String[] args){
        Map m = new HashMap<String, Integer>();
        m.put("jack", 650);
        m.put("tom", 1200);
        m.put("smith", 2900);

        //修改jack的工资为2600
        m.put("jack", 2600);
        System.out.println(m);
        //为所有员工的工资加薪100
        Set keySet = m.keySet();
        for (Object o : keySet) {
            m.put(o, (Integer)m.get(o)+ 100);
            System.out.println(o + "---" + m.get(o));
        }

        //遍历集合中的所有员工
        Set entrySet = m.entrySet();
        Iterator iterator = entrySet.iterator();
        System.out.println("===遍历员工===");
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry set = (Map.Entry) next;
            System.out.println(set.getKey() + "---" + set.getValue());
        }

        //遍历集合中所有的工资 用value遍历输出
        Collection values = m.values();
        System.out.println("===遍历输出工资===");
        for (Object value : values) {
            System.out.println(value);
        }

    }
}
