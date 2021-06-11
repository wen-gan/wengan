package com.wengan.Learning0611.Homework_Exception;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */
public class ArrayExercise {
    public static void main(String[] args){
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦~", 100.0);
        books[1] = new Book("金瓶梅~", 90.0);
        books[2] = new Book("青年文摘~", 5.0);
        books[3] = new Book("Java从入门到放弃~", 300.0);
        //传统方法
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book)o1;
//                Book book2 = (Book)o2;
//                return (int) (book2.getPrice() - book1.getPrice());
//            }
//        });
//        System.out.println("===按照价钱排序后的数组===");
//        for(Book book : books){
//            System.out.println(book.getName());
//        }

        //转换方法
//        Arrays.sort(books, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book book1 = (Book)o1;
//                Book book2 = (Book)o2;
//                double priceVal =book2.getPrice() - book1.getPrice();
//                //进行一个转换
//                if(priceVal > 0){
//                    return 1;
//                }else if(priceVal < 0){
//                    return -1;
//                }else {
//                    return 0;
//                }
//            }
//        });
//        System.out.println("===按照价钱排序后的数组===");
//        for(Book book : books){
//            System.out.println(book.getName());
//        }

        //按照书名的长度从小到大排序
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book)o1;
                Book book2 = (Book)o2;
                //按照书名长度排序
                return book2.getName().length() - book1.getName().length();
            }
        });
        System.out.println("===按照书名长度排序后的数组===");
        for(Book book : books){
            System.out.println(book.getName());
        }
    }
}

class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}