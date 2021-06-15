package com.wengan.Learning0615;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */

public class ArrayExe4 {
    public static void main(String[] args){
        Book[] books = new Book[4];
        books[0] = new Book("Python学习手册", 100.0);
        books[1] = new Book("Java学习手册", 200.0);
        books[2] = new Book("MATLAB学习手册", 50.0);
        books[3] = new Book("C++学习手册", 150.0);
        System.out.println("=====排序前=====");
        for (Book book : books){
            System.out.println(book);
        }
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                //按照名字排
//                return book1.getName().compareTo(book2.getName());

                //名字相同按照价格排
                double priceValue = book1.getPrice() - book2.getPrice();
                if (priceValue > 0){
                    return 1;
                }else if (priceValue < 0){
                    return -1;
                }
                return 0;
            }
        });
        System.out.println("=====排序后=====");
        for (Book book : books){
            System.out.println(book);
        }
    }
}

class Book{
    private String name;
    private double price;

    @Override
    public String toString() {
        return "书名：" + name + "价格：" + price;
    }

    public Book(String name, double price) {
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
}