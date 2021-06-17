package com.wengan.Map;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 */
public class MapMethod {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put("邓超", new Book1(" ", 100));
        map.put("科比", "詹姆斯");
        map.put("科比", "老詹");//不ok
        map.put("杜兰特", "库里");
        map.put("威少", "哈登");
        map.put("欧文", null);
        //输出
        System.out.println(map);
        //去除null
        map.remove(null);
        System.out.println("map=" + map);
        //根据键 取值
        Object val = map.get("哈登");
        System.out.println("val=" + val);
        //获取元素个数
        System.out.println("k-v=" + map.size());
        //判断个数是否为0
        System.out.println(map.isEmpty());
        //清除k-v
        map.clear();
        System.out.println("map= " + map);
        //查找键是否存在
        System.out.println(map.containsKey("科比"));
    }
}
class Book1 {
    private String name;
    private int num;

    @Override
    public String toString() {
        return name + num;
    }

    public Book1(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}