package com.wengan.Set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings("all")
public class TreeSet_ {
    public static void main(String[] args){
        //TreeSet treeSet = new TreeSet();

        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //return ((String) o2).length() - ((String) o1).length();
                return ((String) o2).compareTo((String) o1);
            }
        });
        //使用传统无参构造器，创建TreeSet时，仍然是无序的
        //添加的元素是按照字符串的大小来排序的
        //使用TreeSet提供的一个构造器可以传入一个比较器(匿名内部类)，并制定排序规则

        //添加数据
        treeSet.add("jack");
        treeSet.add("tom");
        treeSet.add("sp");
        treeSet.add("a");
        //在按照长度比较时，加不进去（规则规定了长度相等则加不进去），
        //前面有a , 所以后面的b 也是长度为1的就加不进去了
        treeSet.add("b");

        System.out.println("treeSet = " + treeSet);
    }
}
