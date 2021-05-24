package com.wengan.HouseRent.service;

import com.wengan.HouseRent.domain.House;

public class HouseService {
    private House[] houses;//保存House对象
    private int houseNums = 1;//记录当前有多少个房屋信息
    private int idCounter = 1;//记录当前的id增长到哪个值
    //构造器
    public HouseService(int size){
        //new houses
        houses = new House[size];
        houses[0] = new House(1,"jack","112","海淀区",2000,"未出租");

    }

    //find方法，返回House对象或者null
    public House findById(int findId){
        for (int i = 0; i < houseNums; i++) {
            if(findId == house[i].getId()){
                return houses[i];
            }
        }
        return null;
    }

    //del方法，删除一个房屋信息
    public boolean del(int delId){
        //应当先找到要删除的房屋信息对应的下标
        //一定搞清楚下标和房屋的编号不一致
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if(delId == houses[i].getId()){
                //要删除的房屋(id)是数组下标为i的元素
                index = i;//使用index记录i
            }
        }

        if(index == -1){
            //说明delId在数组中不存在
            return false;
        }
        //如果找到数组
        //
        for (int i = index; i < houseNums-1; i++) {
            houses[i] = houses[i+1];

        }
        //把当前存在的房屋信息的最后一个设置为null
        houses[--houseNums] = null;
        //少一个
        return true;
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newHouse){
        //判断是否还可以继续添加(暂时不考虑数组扩容的问题)
        if(houseNums >= houses.length){
            System.out.println("数组已满，不能再添加...");
            return false;
        }
        //把newHouse对象加入到数组的最后
        houses[houseNums] = newHouse;
        houseNums++;//因为新增加了一个房屋
        //需要设计一个id自增长的机制
        idCounter++;
        newHouse.setId(++idCounter);
        return true;
    }

    //list方法，返回houses数组
    public House[] list(){
        return houses;
    }
}
