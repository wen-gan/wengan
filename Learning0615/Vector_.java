package com.wengan.List;

import java.util.Vector;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Vector_ {
    public static void main(String[] args){
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }
        vector.add(100);
        System.out.println("vector = " + vector);
    }
}
