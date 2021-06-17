package com.wengan.Map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 */
public class Map_ {
    public static void main(String[] args){

        Map map = new HashMap();
        map.put("num1","gan");//k-v
        map.put("num2","shun");//k-v
        map.put("num2","shun");//k-v 当有相同的k，就等价于替换
        map.put(null, null);

        System.out.println(map);
    }
}
