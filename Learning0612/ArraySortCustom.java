package com.wengan.Learning0612;

import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class ArraySortCustom {
    public static void main(String[] args){

        int[] arr = {2, 34, 55, 22, -4};
        int[] arrNew = bubble1(arr);
        for(int i : arrNew){
            System.out.print(i + " ");
        }
        System.out.println("\n"+"===新方法===");
        bubble2(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int i1 = (Integer)o1;
                int i2 = (Integer)o2;
                return i1 - i2;
            }
        });
    }

    public static int[] bubble1(int[] arr){
        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public static void bubble2(int[] arr, Comparator c){
        int temp = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(c.compare(arr[j], arr[j+1]) > 0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        for(int i : arr){
            System.out.print(i + " ");
        }
    }
}
