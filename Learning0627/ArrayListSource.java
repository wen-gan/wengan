package com.wengan.Learning0627;

import java.util.ArrayList;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ArrayListSource {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        for (int i = 11; i <= 15; i++) {
            list.add(i);
        }

        list.add(100);
        list.add(200);
        list.add(null);
    }
}
