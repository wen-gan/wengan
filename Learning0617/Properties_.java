package com.wengan.Map;

import java.util.Properties;
/**
 * @author 文淦
 * @version 1.0
 */
public class Properties_ {
    public static void main(String[] args){
        Properties properties = new Properties();
        properties.put("jonh", 100);
        properties.put("jack", 100);
        properties.put("lucy", 100);
        properties.put("lic", 80);

        System.out.println("properties = " + properties);

        //通过k 获取对应值
        System.out.println(properties.get("lic"));

        //删除
        properties.remove("lic");

        //修改
        properties.put("john", "约翰");
        System.out.println(properties);
    }
}
