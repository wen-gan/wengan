package com.wengan.string_;

public class String01 {
    public static void main(String[] args) {

        String name = "jack";
        name = "tom";
        final char[] value = {'a','b','c'};
        char[] v2 = {'t','o','m'};
        value[0] = 'H';
        //value = v2; 不可以修改 value地址

    }
}
