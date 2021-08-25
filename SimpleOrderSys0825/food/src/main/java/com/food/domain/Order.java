package com.food.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * 订单表
 */

public class Order {

    private Integer id;
    private int queue;
    private Date createTime;
    private String statue;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date completionTime;
    private double totalMoney;
    private String discount;
    private double trueMoney;
    private Integer userId;

    private List<Menu> menus;

    public Order() {
    }

    public Order(Integer id, int queue, Date createTime, String statue, Date completionTime, double totalMoney, String discount, double trueMoney, Integer userId, List<Menu> menus) {
        this.id = id;
        this.queue = queue;
        this.createTime = createTime;
        this.statue = statue;
        this.completionTime = completionTime;
        this.totalMoney = totalMoney;
        this.discount = discount;
        this.trueMoney = trueMoney;
        this.userId = userId;
        this.menus = menus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public double getTrueMoney() {
        return trueMoney;
    }

    public void setTrueMoney(double trueMoney) {
        this.trueMoney = trueMoney;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", queue=" + queue +
                ", createTime=" + createTime +
                ", statue='" + statue + '\'' +
                ", completionTime=" + completionTime +
                ", totalMoney=" + totalMoney +
                ", discount='" + discount + '\'' +
                ", trueMoney=" + trueMoney +
                ", userId=" + userId +
                ", menus=" + menus +
                '}';
    }
}
