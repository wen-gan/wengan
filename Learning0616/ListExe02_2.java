package com.wengan.List;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
public class ListExe02_2 {
    public static void main(String[] args){
        //List<Book1> books = new ArrayList<>(); //用ArrayList
        //List<Book1> books = new Vector<>(); //用Vector
        List<Book1> books = new LinkedList<>(); //用LinkedList

        books.add(new Book1("三国", 200, "罗贯中"));
        books.add(new Book1("水浒传", 300, "施耐庵"));
        books.add(new Book1("西游记", 100, "吴承恩"));
        books.add(new Book1("红楼梦", 50, "曹雪芹"));

        books.sort(new Comparator<Book1>() {
            @Override
            public int compare(Book1 book1, Book1 book2) {
                double priceValue = book1.getPrice() - book2.getPrice();
                if (priceValue > 0) {
                    return 1;
                }else if (priceValue < 0){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        Iterator<Book1> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book1 book =  iterator.next();
            System.out.println("book = " + book);
        }
    }
}

class Book1{
    private String name;
    private double price;
    private String author;

    @Override
    public String toString() {
        return "名称：" + name + "\t\t价格：" + price + "\t\t作者：" + author;
    }

    public Book1(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}