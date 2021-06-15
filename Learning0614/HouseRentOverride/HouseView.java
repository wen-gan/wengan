package com.wengan.Learning0614.HouseRentOverride;

import com.wengan.Learning0613.HouseRentOverride.Utility;

/**
 * @author 文淦
 * @version 1.0
 */
public class HouseView {
    private boolean loop = true;//控制主菜单
    private char key = ' ';//接受用户选择
    private com.wengan.Learning0614.HouseRentOverride.HouseServise houseServise = new com.wengan.Learning0614.HouseRentOverride.HouseServise(8);

    //修改房屋信息
    public void update(){
        System.out.println("=============修改房屋信息=============");
        System.out.println("请输入要修改的房屋编号（-1表示退出）：");
        int updateId = Utility.readInt();
        if (updateId == -1){
            System.out.println("=============放弃修改房屋信息=============");
            return;
        }

        //根据输入的updateId进行查找

        com.wengan.Learning0614.HouseRentOverride.House house = houseServise.findbyId(updateId);
        if(house == null){
            System.out.println("=============要修改的房屋信息不存在=============");
            return;
        }

        System.out.println("姓名（" + house.getName() + "):");
        String name = Utility.readString(12, " ");
        if (!"".equals(name)){
            house.setName(name);
        }

        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "): ");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("=============修改房屋信息成功============");

    }


    //查找房屋信息
    public void findHouse(){
        System.out.println("=============查找房屋信息=============");
        System.out.println("请输入要查找的房屋id：");
        int findid = Utility.readInt();

        com.wengan.Learning0614.HouseRentOverride.House house = houseServise.findbyId(findid);
        if (house != null){
            System.out.println(house);
        }else {
            System.out.println("=============查找的房屋信息不存在=============");
        }
    }


    //推出系统
    public void exit(){
        char c = Utility.readConfirmSelection();
        if (c == 'Y'){
            loop = false;
        }
    }

    //删除房屋信息
    public void delHouse(){
        System.out.println("=============删除房屋信息=============");
        System.out.println("请输入待删除房屋的编号(-1退出)：");
        int delId = Utility.readInt();
        if(delId == -1){
            System.out.println("=============放弃删除房屋信息=============");
            return;
        }
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y'){
            if(houseServise.del(choice)){
                System.out.println("=============删除房屋信息成功=============");
            }else {
                System.out.println("=============房屋编号不存在，删除失败=============");
            }
        }else {
            System.out.println("=============放弃删除房屋信息=============");
        }
    }

    //新增房屋信息
    public void addHouse(){
        System.out.println("=============新增房屋信息=============");
        System.out.println("姓名：");
        String name = Utility.readString(8);
        System.out.println("电话：");
        String phone = Utility.readString(12);
        System.out.println("地址：");
        String address = Utility.readString(6);
        System.out.println("月租：");
        int rent = Utility.readInt();
        System.out.println("状态：");
        String state = Utility.readString(3);
        //创建新的 House对象
        com.wengan.Learning0614.HouseRentOverride.House newHouse = new com.wengan.Learning0614.HouseRentOverride.House(0,name,phone,address,rent,state);
        if(houseServise.add(newHouse)){
            System.out.println("=============添加房屋成功=============");
        }else {
            System.out.println("=============添加房屋失败=============");
        }
    }

    //显示输入的房屋信息列表
    public void listHouse(){
        System.out.println("=============房屋列表=============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        com.wengan.Learning0614.HouseRentOverride.House[] houses = houseServise.list();
        for (int i = 0; i<houses.length;i++){
            if(houses[i] == null){
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("=============房屋列表显示完毕=============");
    }


    //显示主菜单
    public void mainMenu(){
        do{
            System.out.println("=============房屋出租系统=============");
            System.out.println("\t\t\t1 新 增 房 屋 信 息");
            System.out.println("\t\t\t2 查 找 房 屋 信 息");
            System.out.println("\t\t\t3 删 除 房 屋 信 息");
            System.out.println("\t\t\t4 修 改 房 屋 信 息");
            System.out.println("\t\t\t5 房 屋 信 息 列 表");
            System.out.println("\t\t\t5 退   出   系   统");
            System.out.println("请输入你的选择（1-6）：");
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
                    update();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }
        }while(loop);
    }
}
