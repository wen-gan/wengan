package com.wengan.Learning0627;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ListMethod {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("杜兰特");
        list.add("科比");
//        void add(int index, Object ele):在index位置插入ele元素
        //在index = 1的位置插入一个对象
        list.add(1, "学习Java");
        System.out.println("list=" + list);
//        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(1, list2);
        System.out.println("list=" + list);
//        Object get(int index):获取指定index位置的元素
        //说过
//        int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("tom"));//2
//        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        list.add("学习Java");
        System.out.println("list=" + list);
        System.out.println(list.lastIndexOf("学习Java"));
//        Object remove(int index):移除指定index位置的元素，并返回此元素
        list.remove(0);
        System.out.println("list=" + list);
//        Object set(int index, Object ele):设置指定index位置的元素为ele , 相当于是替换.
        list.set(1, "威少");
        System.out.println("list=" + list);
//        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        // 注意返回的子集合 fromIndex <= subList < toIndex
        List returnlist = list.subList(0, 2);
        System.out.println("returnlist=" + returnlist);
    }
}
