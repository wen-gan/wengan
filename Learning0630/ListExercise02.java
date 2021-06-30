package com.wengan.Learning0630;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ListExercise02 {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
//        LinkedList<Book> books = new LinkedList<>();
//        Vector<Book> books = new Vector<>();

        books.add(new Book("红楼梦", 100,"曹雪芹"));
        books.add(new Book("西游记", 10,"吴承恩"));
        books.add(new Book("水浒传", 19,"施耐庵"));
        books.add(new Book("三国志", 80,"罗贯中"));

        //遍历输出(没有排序)
        System.out.println("====遍历输出(无排序)====");
        for (Book book : books) {
            System.out.println(book);
        }

        //按照价格进行冒泡排序
        books.sort(new Comparator<Book>() {
            @Override
            public int compare(Book book1, Book book2) {
                if (!(book1 instanceof Book && book2 instanceof Book)){
                    return 0;
                }

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

        System.out.println("====遍历输出(排序后)====");
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }
}

class Book {
    private String name;
    private double price;
    private String anthor;

    public Book(String name, double price, String anthor) {
        this.name = name;
        this.price = price;
        this.anthor = anthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", anthor='" + anthor + '\'' +
                '}';
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

    public String getAnthor() {
        return anthor;
    }

    public void setAnthor(String anthor) {
        this.anthor = anthor;
    }
}