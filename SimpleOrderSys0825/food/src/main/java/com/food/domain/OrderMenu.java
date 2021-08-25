package com.food.domain;

/**
 * @author 文淦
 * @version 1.0
 * 菜单内容表
 */

public class OrderMenu {

    private Integer orderId;
    private Integer menuId;
    private Integer amount;

    public OrderMenu() {
    }

    public OrderMenu(Integer orderId, Integer menuId, Integer amount) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.amount = amount;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "orderId=" + orderId +
                ", menuId=" + menuId +
                ", amount=" + amount +
                '}';
    }
}
