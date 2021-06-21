package com.wengan.Learning0621.SimpleOrderingSys2;

import com.wengan.Learning0621.SimpleOrderingSystem.Dishes;
import com.wengan.Learning0621.SimpleOrderingSystem.Order;
import com.wengan.Learning0621.SimpleOrderingSystem.OrderingService;
import com.wengan.Learning0621.SimpleOrderingSystem.Utility;

import java.util.Date;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings("all")
public class OrderingView {
    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接受用户输入
    private OrderingService orderingService = new OrderingService(10);
    private Dishs[] dishs = Dishs.values();

    public void reviseOrder(){
        System.out.println("====修改订单信息====");
        System.out.println("请选择需要修改的订单编号(-1表示退出)：");
        int reviseNum = Utility.readInt();
        if (reviseNum == -1) {
            System.out.println("====放弃修改订单信息====");
            return;
        }

        //查找订单
        Order order = orderingService.find(reviseNum);
        if (order == null) {
            System.out.println("====修改的订单不存在====");
            return;
        }
        //逐项修改
        System.out.println("菜品(" + order.getDishDetails().getName() + ")：");
        //直接输入回车表示不修改信息
        String dish = Utility.readString(12," ");
        System.out.println("规格(" + order.getDishDetails().getSpe() + ")：");
        int spe = Utility.readInt(-1);
        System.out.println("数量(" + order.getDishDetails().getNums() + ")：");
        int nums = Utility.readInt(-1);

        if (!" ".equals(dish) && !"".equals(spe) && !"".equals(nums)) {
            order.setDishDetails(new Dishes(dish,spe,nums));
        }

        System.out.println("订单状态(" + order.getState() + ")：");
        String state = Utility.readString(3," ");
        if (!"".equals(state)) {
            order.setState(state);
        }

        System.out.println("折扣信息(" + order.getDiscount() + ")：");
        int discount = Utility.readInt(-1);
        if (!"".equals(discount)) {
            order.setDiscount(discount);
        }

        System.out.println("实际付款(" + order.getActualAmount() + ")：");
        int actualAmount = Utility.readInt(-1);
        if (!"".equals(actualAmount)) {
            order.setActualAmount(actualAmount);
        }

        System.out.println("会员编号(" + order.getDiscount() + ")：");
        int memberNum = Utility.readInt(-1);
        if (!"".equals(memberNum)) {
            order.setMembernum(memberNum);
        }
        System.out.println("====订单信息修改成功====");
    }

    public void delOrders() {
        System.out.println("====删除订单信息====");
        System.out.println("请输入待删除的订单信息(-1退出)：");
        int delOrdernum = Utility.readInt();
        if (delOrdernum == -1){
            System.out.println("====放弃删除订单信息====");
            return;
        }

        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (orderingService.del(delOrdernum)) {
                System.out.println("====订单删除成功====");
            }else {
                System.out.println("====订单不存在====");
            }
        }else {
            System.out.println("====放弃删除订单信息====");
        }
    }

    //点餐(添加订单信息)
    public void addOrders(){
        System.out.println("====点餐====");
        System.out.println("菜品：");
        String dish = Utility.readString(20);

        //点餐 减少相应菜品次数
        for (Dishs dish_ : dishs) {
            if(dish == dish_.getName()){
                System.out.println("找到该菜品");
                if (dish_.getTimes() == 0) {
                    System.out.println("该菜品已卖完，请选择其他菜品");
                    return;
                }else {
                    dish_.setTimes(dish_.getTimes()-1);
                    System.out.println("该菜品还剩" + dish_.getTimes() + "份");
                }
            }
        }
        int dishCount = 0;

        System.out.println("规格：");
        int spc = Utility.readInt();
        System.out.println("份数：");
        int num = Utility.readInt();
        System.out.println("订单状态：");
        String state = Utility.readString(3);
        System.out.println("折扣信息：");
        double discount = Utility.readInt(1);
        System.out.println("实际付款：");
        int actualAmount = Utility.readInt();
        System.out.println("会员编号：");
        int memberNum = Utility.readInt();

        Order newOrder = new Order(0, 1, new Dishes(dish, spc, num), new Date(), state, new Date(),
                discount, actualAmount, memberNum);


        if (orderingService.add(newOrder)) {
            System.out.println("====添加订单成功====");
            if (newOrder.getTotalAmount() > 100) {
                System.out.println("消费超过100元，赠送一份低于10元的菜品");
            }
        }else {
            System.out.println("====添加订单失败====");
        }
    }

    //退出系统
    public void exit(){
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }
    //显示订单信息
    public void display(){
        System.out.println("====订单信息====");
        System.out.println("订单编号\t\t排队序号\t\t\t菜品详情\t\t\t\t\t\t订单生成时间\t\t\t订单状态(已完成/未完成)\t\t\t订单完成时间" +
                "\t\t\t订单总金额\t\t折扣信息\t实付款\t会员编号");
        Order[] orders = orderingService.list();
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i] == null) {
                break;
            }
            System.out.println(orders[i]);
        }
        System.out.println("====订单信息显示完毕====");
    }

    public void mainMenu() {
        do {
            System.out.println("====简易点餐系统====");
            System.out.println("1 点        餐");
            System.out.println("2 查看订单信息");
            System.out.println("3 修改订单信息");
            System.out.println("4 删除订单信息");
            System.out.println("5 退        出");
            System.out.print("请输入你的选择(1-5)：");
            key = Utility.readChar();

            switch (key) {
                case '1':
                    addOrders();
                    break;
                case '2':
                    display();
                    break;
                case '3':
                    reviseOrder();
                    break;
                case '4':
                    delOrders();
                    break;
                case '5':
                    exit();
                    break;
            }
        }while(loop);
    }
}
