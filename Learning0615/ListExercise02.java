package com.wengan.List;

import java.util.*;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class ListExercise02 {
    public static void main(String[] args){
        //List list = new ArrayList();
        //List list = new Vector();
        List list = new LinkedList();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 9));
        list.add(new Book("三国", "罗贯中", 80));

        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book)o1;
                Book book2 = (Book)o2;
                double priceValue = book1.getPrice() - book2.getPrice();
                if (priceValue > 0){
                    return 1;
                }else if(priceValue < 0){
                    return -1;
                }
                return 0;
            }
        });

        //用迭代器遍历
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        //升级for()循环遍历
        for (Object i : list){
            System.out.println(i);
        }
    }
}

class Book{
    private String name;
    private String author;
    private double price;

    @Override
    public String toString() {
        return "书名：" + name + "\t\t" + "作者：" + author + "\t\t" + "价格：" + price;
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