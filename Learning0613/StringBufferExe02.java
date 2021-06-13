package com.wengan.Learning0612;

/**
 * @author 文淦
 * @version 1.0
 */
public class StringBufferExe02 {
    public static void main(String[] args){
        String price = "1233456.7";
        StringBuffer sb = new StringBuffer(price);
        //找到小数点的索引，然后在该位置的前3位插入即可
//        int i = sb.lastIndexOf(".");
//        sb = sb.insert(i - 3, ",");

        for(int i = sb.lastIndexOf(".")-3; i > 0; i -= 3){
            sb = sb.insert(i, ",");
        }
        System.out.println(sb);
    }

}

