package com.wengan.Learning0612;


import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */
public class ArrayExercise {
    public static void main(String[] args){
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅", 90);
        books[2] = new Book("青年文摘", 7);
        books[3] = new Book("java入门", 500);

        Arrays.sort(books, new Comparator<Book>() {
            //这里是对Book数组排序，因此  o1 和 o2 就是Book对象
            @Override
            public int compare(Book book1, Book book2) {
                double priceVal = book2.getPrice() - book1.getPrice();
                //这里老师进行了一个转换
                //如果发现返回结果和我们输出的不一致，就修改一下返回的 1 和 -1
                if(priceVal > 0) {
                    return  1;
                } else  if(priceVal < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(Arrays.toString(books));
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
    public String toString() {
        return "书名："+ name + "价格" + price;
    }
}