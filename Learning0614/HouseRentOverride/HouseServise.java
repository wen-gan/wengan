package com.wengan.Learning0614.HouseRentOverride;

/**
 * @author 文淦
 * @version 1.0
 */
public class HouseServise {
    private com.wengan.Learning0614.HouseRentOverride.House[] houses;
    private int housesNums = 1;
    private int idCount = 1;

    public HouseServise(int size){
        //新增一个House对象
        houses = new com.wengan.Learning0614.HouseRentOverride.House[size];

        houses[0] = new com.wengan.Learning0614.HouseRentOverride.House(1,"jack","123", "海淀区", 2000,"未出租");
    }

    //查找房屋
    public com.wengan.Learning0614.HouseRentOverride.House findbyId(int findId){
        //遍历数组查找id
        for (int i = 0; i < housesNums; i++) {
            if(findId == houses[i].getId()){
                return houses[i];
            }
        }
        return null;
    }

    //list方法来返回houses
    public com.wengan.Learning0614.HouseRentOverride.House[] list(){
        return houses;
    }

    //删除房屋
    public boolean del(int delid){
        //首先找到要删除的房屋的下标
        int index = -1;
        for (int i = 0; i < housesNums; i++) {
            if(delid == houses[i].getId()){
                index = i;
            }
        }
        //删除信息的原理便是：
        //首先找到要删除的房屋的id，然后把这个id后面的所有房屋依次向前填补
        //然后把最后一个位置制空null
        if(index == -1){
            return false;
        }
        for (int i = index; i < housesNums - 1; i++) {
            houses[i] = houses[i+1];
        }
        houses[--housesNums] = null;
        return true;
    }

    //添加新的房屋
    public boolean add(com.wengan.Learning0614.HouseRentOverride.House newHouse){
        //首先判断是否可以继续添加
        if(housesNums == houses.length){
            System.out.println("数组已满，无法继续添加");
            return false;
        }
        //新增一个房屋，需要对原来的数组进行扩容
        houses[housesNums++] = newHouse;
        //id自增长
        newHouse.setId(++idCount);
        return true;
    }
}
