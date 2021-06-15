package com.wengan.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 文淦
 * @version 1.0
 */
public class CollectionIterator {
    public static void main(String[] args){
        Collection col = new ArrayList();
        ((ArrayList) col).add(new Book("Java学习", "kkk", 100.0));
        ((ArrayList) col).add(new Book("Python学习", "ppp", 58.4));
        ((ArrayList) col).add(new Book("C++学习", "ccc", 70.6));

        Iterator iterator = col.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        //再次遍历需要重置迭代器
        //iterator = col.iterator();

    }
}

class Book{
    private String name;
    private String author;
    private double price;

    @Override
    public String toString() {
        return name + "," + author + "," + price;
    }

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}