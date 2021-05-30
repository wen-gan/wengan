package com.wengan.houserent_wengan.service;

import com.wengan.houserent_wengan.domain.House;

public class Houseservice {
    private com.wengan.houserent_wengan.domain.House[] houses;
    private int houseNum = 1;
    private int idCount = 1;

    //查找房屋信息
    public House findbyId(int findId){
        for (int i = 0; i < houseNum; i++) {
            if(findId == houses[i].getId()){
                return houses[i];
            }

        }
        return null;
    }


    //删除房屋
    public boolean del(int delId){
        int index_ = -1;
        for (int i = 0; i < houseNum; i++) {
            if(delId == houses[i].getId()){
                index_ = i;
            }
        }

        if(index_ == -1){
            return false;
        }
        for (int i = index_; i < houseNum; i++) {
            houses[i] = houses[i+1];
        }
        //把最后一个房屋信息制空
        houses[--houseNum] = null;
        return true;
    }

    //新增房屋
    public boolean add(House newHouse){
        if(houseNum == houses.length){
            System.out.println("列表已满，无法再添加");
            return false;
        }
        //把newHouse加入到house里
        houses[houseNum++] = newHouse;
        //id需要自增长
        newHouse.setId(++idCount);
        return true;
    }

    //显示房屋信息
    public Houseservice(int size){
        houses = new House[size];
        //新增一个初始化房屋信息
        houses[0] = new House(1,"jack","456","东丽区",2200,"已出租");

    }
    public House[] listh(){
        return houses;
    }
}
