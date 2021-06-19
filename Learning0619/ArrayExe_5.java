package com.wengan.Learning0619;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */
public class ArrayExe_5 {
    public static void main(String[] args) {
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
                if (!(book1 instanceof Book && book2 instanceof Book)) {
                    return 0;
                }

                //按照书名排序
                //return book1.getName().length() - book2.getName().length();
//                int nameValue = book1.getName().compareTo(book2.getName());
//                if (nameValue != 0) {
//                    return nameValue;
//                }

                //按照价格排序
                double priceValue = book1.getSal() - book2.getSal();
                if (priceValue > 0) {
                    return -1;
                }else if (priceValue < 0) {
                    return 1;
                }else {
                    return 0;
                }

            }
        });

        System.out.println("====排序后====");
        for (Book book : books){
            System.out.println(book);
        }
    }
}

class Book {
    private String name;
    private double sal;

    @Override
    public String toString() {
        return "书名：" + name + "\t价格：" + sal;
    }

    public Book(String name, double sal) {
        this.name = name;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }
}