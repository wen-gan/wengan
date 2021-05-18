package com.wengan.super_;

public class Fibbonce {
    public static void main(String[] args){
        int n = 10;
        int nums[] = new int[n];
        fib f1 = new fib(n,nums);
        f1.f(n);
        for (int i = 0; i < n; i++) {
            System.out.println(f1.nums[i]);//输出第n个数列值
        }
    }
}

class fib{
    int n;
    public int[] nums;

    public fib(int n, int[] nums) {
        this.n = n;
        this.nums = nums;
    }

    public void f(int n){
            if(n==1){
                nums[0] = 1;
            }else if(n==2){
                nums[1] = 1;
                f(n-1);
            }else{
                f(n-1);
                nums[n-1] = nums[n-2] + nums[n-3];
            }
    }
}