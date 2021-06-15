package com.wengan.collection_;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})

public class Collection_ {
    public static void main(String[] args){
        List list = new ArrayList();

        //添加单个元素 add()
        list.add("jack");
        list.add(10);
        list.add('c');
        System.out.println(list);
        //删除指定元素 remove()
        list.remove("jack");
        System.out.println(list);
        //查找元素是否存在 contain()
        System.out.println(list.contains("jack"));
        //获取元素个数 size()
        System.out.println(list.size());
        //判断是否为空 isEmpty()
        System.out.println(list.isEmpty());
        //清空 clear
        list.clear();
        System.out.println("list = " + list);
        //添加多个元素 addAll
        ArrayList list2 = new ArrayList();
        list2.add("Java");
        list2.add("Python");
        list2.add("C++");
        list.addAll(list2);
        System.out.println(list);
        //查找多个元素是否存在 containAll
        System.out.println(list.containsAll(list2));
        //删除多个元素 removeAll
        list.removeAll(list2);
        System.out.println(list);
    }
}
