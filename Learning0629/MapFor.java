package com.wengan.Learning0629;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class MapFor {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超", "孙俪");
        map.put("王宝强", "马蓉");
        map.put("宋喆", "马蓉");
        map.put("刘令博", null);
        map.put(null, "刘亦菲");
        map.put("鹿晗", "关晓彤");

        //keySet遍历输出
        Set keySet = map.keySet();

        System.out.println("====增强for循环====");
        for (Object key : keySet) {
            System.out.println(key + "--->" + map.get(key));
        }

        System.out.println("====迭代器循环====");
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            System.out.println(key + "---->" + map.get(key));
        }

        //entrySet遍历输出
        Set entrySet = map.entrySet();
        System.out.println("====使用增强for循环输出====");
        for (Object entry : entrySet) {
            Map.Entry entry_ = (Map.Entry) entry;
            System.out.println(entry_.getKey() + "---" + ((Map.Entry) entry).getValue());
        }

        System.out.println("====使用迭代器循环输出====");
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object entry = iterator1.next();
            Map.Entry entry1 = (Map.Entry) entry;
            System.out.println(entry1.getKey() + "---" + entry1.getValue());
        }

        //输出value
        Collection values = map.values();
        System.out.println("====取出所有的values 增强for循环====");
        for (Object value : values) {
            System.out.println(value);
        }

        System.out.println("====取出所有的values 迭代器循环====");
        Iterator iterator2 = values.iterator();
        while (iterator2.hasNext()) {
            Object value = iterator2.next();
            System.out.println(value);
        }

    }
}
