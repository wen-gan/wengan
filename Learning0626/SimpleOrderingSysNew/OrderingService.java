package com.wengan.Learning0621.SimpleOrderingSysNew;

import java.util.Date;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings("all")
public class OrderingService {
    private Order[] orders;
    private int ordernums = 1;//记录当前的订单信息个数

    private int orderCount = 1;
    private int queueCount = 0;


    public OrderingService(int size) {
        orders = new Order[size];
        orders[0] = new Order(1, 0,new Dishes("蛋炒饭", 6, 1), new Date(),
                "已完成", new Date(), 10, 6);
    }

    //查找订单信息
    public Order find(int findOrdernum) {
        //遍历
        for (int i = 0; i < ordernums; i++){
            if (findOrdernum == orders[i].getOrdernum()) {
                return orders[i];
            }
        }
        return null;
    }

    //删除订单信息
    public boolean del(int delOrdernum) {
        //遍历数组进行查找
        int index = -1;
        for (int i = 0; i < ordernums; i++) {
            if (delOrdernum == orders[i].getOrdernum()){
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }

        for (int i = index; i < ordernums; i++) {
            orders[i] = orders[i+1];
        }

        //把最后一个置空
        orders[--ordernums] = null;
        return true;
    }

    //添加订单信息
    public boolean add(Order neworder) {
        if (ordernums == orders.length) {
            System.out.println("订单已满，无法再添加...");
            return false;
        }

        //将新的订单信息加入到订单列表里
        orders[ordernums++] = neworder;


        //订单编号需要自增长
        neworder.setOrdernum(++orderCount);
        neworder.setQueuenum(++queueCount);
        return true;
    }

    public Order[] list(){
        return orders;
    }
}
