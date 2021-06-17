package com.wengan.Map;

import java.util.Hashtable;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings("all")
public class HashTableExercise {
    public static void main(String[] args){
        Hashtable table = new Hashtable();
        table.put("john" ,100);//ok
        //table.put(null ,100);//异常 NullPointerException
        //table.put("john" ,null);//异常 NullPointerException
        table.put("lucy" ,100);//ok
        table.put("lic" ,100);//ok
        table.put("lic" ,88);//替换
        table.put("hello1", 1);
        table.put("hello2", 2);
        table.put("hello3", 3);
        table.put("hello4", 4);
        table.put("hello5", 5);
        table.put("hello6", 6);
        table.put("hello7", 7);
        System.out.println(table);

    }
}
