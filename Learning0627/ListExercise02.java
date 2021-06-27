package com.wengan.Learning0627;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ListExercise02 {
    public static void main(String[] args) {
        //List list = new ArrayList();
        List list = new LinkedList();
        //List list = new Vector();

        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));

        //对集合进行遍历排序
        System.out.println("====排序前====");
        for (Object obj : list) {
            System.out.println(obj);
        }
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;

                //按照价格排序
                double priceValue = book1.getPrice() - book2.getPrice();
                if (priceValue > 0) {
                    return 1;
                }else if (priceValue < 0) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println("====自定义排序后====");
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
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