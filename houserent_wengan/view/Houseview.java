package com.wengan.houserent_wengan.view;

import com.wengan.houserent_wengan.Utility;
import com.wengan.houserent_wengan.domain.House;
import com.wengan.houserent_wengan.service.Houseservice;

public class Houseview {
    private boolean loop = true;
    private char key;
    private Houseservice houseService = new Houseservice(10);

    //退出
    public void exit(){
        char c = Utility.readConfirmSelection();
        if(c == 'Y'){
            loop = false;
        }
    }

    //修改房屋信息
    public void updateHouse(){
        System.out.println("==============修改房屋信息==============");
        System.out.println("请选择待修改房屋编号(-1退出)");
        int updateid = Utility.readInt();
        if(updateid == -1){
            System.out.println("==============你放弃修改房屋信息==============");
            return;
        }
        //根据查找到的id，查找对象
        House house = houseService.findbyId(updateid);
        if(house == null){
            System.out.println("==============修改的房屋信息不存在==============");
            return;
        }
        System.out.print("姓名("+house.getName()+"):");
        //这里如果用户直接回车表示不修改信息，默认""
        String name = Utility.readString(8,"");
        if(!"".equals(name)){
            house.setName(name);
        }

        System.out.print("电话("+house.getPhone()+"):");
        //这里如果用户直接回车表示不修改信息，默认""
        String phone = Utility.readString(12,"");
        if(!"".equals(phone)){
            house.setPhone(phone);
        }

        System.out.print("地址("+house.getAddress()+"):");
        //这里如果用户直接回车表示不修改信息，默认""
        String address = Utility.readString(3,"");
        if(!"".equals(address)){
            house.setAddress(address);
        }

        System.out.print("月租("+house.getRent()+"):");
        //这里如果用户直接回车表示不修改信息，默认""
        int rent = Utility.readInt(-1);
        if(!"".equals(rent)){
            house.setRent(rent);
        }

        System.out.print("状态("+house.getState()+"):");
        //这里如果用户直接回车表示不修改信息，默认""
        String state = Utility.readString(5,"");
        if(!"".equals(state)){
            house.setState(state);
        }
        System.out.println("=============修改房屋信息完成=============");
    }


    //查找房屋信息
    public void findHouse(){
        System.out.println("================查找房屋================");
        System.out.println("请输出你要查找的id：");
        int findid = Utility.readInt();

        House house = houseService.findbyId(findid);
        if(house != null){
            System.out.println(house);
        }else{
            System.out.println("============查找的房屋信息不存在============");
        }
    }

    //删除房屋
    public void delHouse(){
        System.out.println("================删除房屋================");
        System.out.println("请选择待删除房屋编号(-1退出)");
        int delId = Utility.readInt();
        if(delId == -1){
            System.out.println("================放弃删除房屋信息================");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if(choice == 'Y'){
            if(houseService.del(delId)){
                System.out.println("================删除房屋成功================");
            }else{
                System.out.println("=============房屋编号不存在，删除失败=============");
            }
        }else {
            System.out.println("================放弃删除房屋信息================");
        }
    }


    //新增房屋
    public void addHouse(){
        System.out.println("================添加房屋================");
        System.out.println("姓名：");
        String name = Utility.readString(8);
        System.out.println("电话：");
        String phone = Utility.readString(12);
        System.out.println("地址：");
        String address = Utility.readString(8);
        System.out.println("月租：");
        int rent = Utility.readInt(-1);
        System.out.println("状态：");
        String state = Utility.readString(3);
        House newhouse = new House(0,name,phone,address,rent,state);
        if(houseService.add(newhouse)){
            System.out.println("============添加房屋成功============");
        }else{
            System.out.println("============添加房屋失败============");
        }
    }

    //显示房屋列表
    public void listHouse(){
        System.out.println("================房屋列表================");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(已出租/未出租)");
        House[] houses = houseService.listh();
        for (int i = 0; i < houses.length; i++) {
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("================房屋列表显示完毕================");

    }

    public void mainMeun(){

        do {

            System.out.println("================房屋出租系统================");
            System.out.println("\t\t\t1 新 增 房 源");
            System.out.println("\t\t\t2 查 找 房 屋");
            System.out.println("\t\t\t3 删 除 房 屋");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 列 表");
            System.out.println("\t\t\t6 退       出");
            System.out.println("请输入你的选择(1-6)：");
            key = Utility.readChar();
            switch (key){
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }

        }while (loop);
    }
}
