package com.wengan.Learning0611.Homework_Exception;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */
public class ArrayMethod01 {
    public static void main(String[] args){
        Integer[] integers = {1, 20,90};
        System.out.println(Arrays.toString(integers));

        //sort方法的使用
        Integer arr[] = {1,-1,7,8,12,2};
        //默认排序方法
//        Arrays.sort(arr);
        //实现定制排序
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Integer i1 = (Integer)o1;
                Integer i2 = (Integer)o2;
                return i2-i1;
            }
        });
        System.out.println("==排序后==");
        System.out.println(Arrays.toString(arr));
    }
}
