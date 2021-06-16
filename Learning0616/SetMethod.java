package com.wengan.List;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 文淦
 * @version 1.0
 */
public class SetMethod {
    public static void main(String[] args){
        Set set = new HashSet();
        //Set接口实现类的对象，不能存放重复的元素
        //可以添加一个null
        //Set接口对象存放数据是无序的（即添加的顺序和取出的顺序不一致）
        //但取出的顺序是固定的（虽然不是添加的顺序）
        set.add("john");
        set.add("lucy");
        set.add("john");
        set.add("jack");
        set.add(null);
        set.add(null);
        System.out.println("======用迭代器======");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println(obj);
        }
        set.remove(null);
        System.out.println("===========用增强for循环=============");
        for (Object obj : set) {
            System.out.println("obj = " + obj);
        }

    }
}
