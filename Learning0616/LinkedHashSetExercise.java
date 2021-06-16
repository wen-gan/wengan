package com.wengan.List;

import java.util.LinkedHashSet;
import java.util.Objects;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class LinkedHashSetExercise {
    public static void main(String[] args){
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new Car("奥拓", 10000));
        linkedHashSet.add(new Car("奥迪", 100000));
        linkedHashSet.add(new Car("法拉利", 3000000));
        linkedHashSet.add(new Car("保时捷", 7000000));
        linkedHashSet.add(new Car("奥迪", 100000));
        linkedHashSet.add(new Car("保时捷", 7000000));

        System.out.println(linkedHashSet);
    }
}

class Car{
    private String name;
    private double price;

    @Override
    public String toString() {
        return "\n"+"车名：" + name + "\t\t价格：" + price;
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}