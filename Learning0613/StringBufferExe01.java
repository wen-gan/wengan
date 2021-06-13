package com.wengan.Learning0612;

/**
 * @author 文淦
 * @version 1.0
 */
public class StringBufferExe01 {
    public static void main(String[] args){

        try {
            String str = null;//ok
            StringBuffer sb = new StringBuffer();//ok
            sb.append(str);//需要看源码，底层调用的是AbstractStringBuilder的appendNull
            System.out.println(sb.length());//sb保存的是‘n’‘u’‘l’‘l’，所以长度为4

            System.out.println(sb);//输出null
            StringBuffer sb1 = new StringBuffer(str);
            System.out.println(sb1);
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        }
    }
}
