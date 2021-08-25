package com.food.domain;

/**
 * @author 文淦
 * @version 1.0
 * 菜单表
 */

public class Menu {

    private int id;
    private String name;
    private double price;
    private int supply;
    private String type;

    private int amount;

    public Menu() {
    }

    public Menu(int id, String name, double price, int supply, String type, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.supply = supply;
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSupply() {
        return supply;
    }

    public void setSupply(int supply) {
        this.supply = supply;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supply=" + supply +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
