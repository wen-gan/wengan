package com.wengan.Learning0620;

/**
 * @author 文淦
 * @version 1.0
 */
public class BubbleSort {
    public static void main(String[] args){
        int a[] = {21,11,2,43,77,66,44,46};
        int temp = 0;
        System.out.println("====冒泡排序前====");
        for (Object i : a) {
            System.out.print(i + " ");
        }
        //冒泡排序
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println("\n" + "====冒泡排序后====");
        for (Object i : a) {
            System.out.print(i + " ");
        }

    }
}
