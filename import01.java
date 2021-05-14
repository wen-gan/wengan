package com.wengan.pkg;


import java.util.Arrays;

public class import01 {
    public static void main(String[] args){
        //使用系统提供的Arrays 完成数组排序
        int arr[] = {-1,20,2,3,44};
        //要进行排序的传统方法为自己编写排序程序(如冒泡排序方法)
        //系统也提供了相关的类可以方便完成排序
        Arrays.sort(arr);
        //输出排序结果
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
