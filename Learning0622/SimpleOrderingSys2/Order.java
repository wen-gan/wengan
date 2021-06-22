package com.wengan.Learning0621.SimpleOrderingSys2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 文淦
 * @version 1.0
 */
public class Order {
    //"订单编号 排队序号 菜品详情 订单生成时间 订单状态(已完成/未完成) 订单完成时间" +
    //"订单总金额 折扣信息 实付款 会员编号"
    private int ordernum;
    private int queuenum;
    //菜品详情
    private Dishes dishDetails;
    //订单生成时间
    private Date startdate;
    private String state;
    private Date finishdate;
    //订单总金额
    private double discount;
    private double totalAmount ;
    private double actualAmount;
    private int membernum;

    public String dateTransform(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String datetrans = sdf.format(date);
        return datetrans;
    }

    @Override
    public String toString() {
        return  "\t" + ordernum +
                "\t\t" + queuenum +
                "\t\t\t" + dishDetails +
                "\t\t\t" + dateTransform(startdate) +
                "\t\t" + state +
                "\t\t" + dateTransform(finishdate) +
                "\t" + (totalAmount = dishDetails.getSpe() * dishDetails.getNums() * (discount/10)) +
                "\t\t\t" + discount +
                "\t\t" + actualAmount +
                "\t" + membernum ;
    }

    public Order(int ordernum, int queuenum, Dishes dishDetails, Date startdate, String state, Date finishdate, double discount, double actualAmount, int membernum) {
        this.ordernum = ordernum;
        this.queuenum = queuenum;
        this.dishDetails = dishDetails;
        this.startdate = startdate;
        this.state = state;
        this.finishdate = finishdate;
        this.discount = discount;
        this.actualAmount = actualAmount;
        this.membernum = membernum;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public int getQueuenum() {
        return queuenum;
    }

    public void setQueuenum(int queuenum) {
        this.queuenum = queuenum;
    }

    public Dishes getDishDetails() {
        return dishDetails;
    }

    public void setDishDetails(Dishes dishDetails) {
        this.dishDetails = dishDetails;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }


    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalAmount() {
        return dishDetails.getSpe() * dishDetails.getNums() * (discount/10);
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public int getMembernum() {
        return membernum;
    }

    public void setMembernum(int membernum) {
        this.membernum = membernum;
    }
}
