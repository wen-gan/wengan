package com.wengan.Learning0620;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework01_3 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度信教徒奔赴恒河圣浴，引起民众担忧");
        News news2 = new News("凯文杜兰特超神表现，抢七决战打满53分钟，狂砍48分难救主");
        ArrayList<News> news = new ArrayList<>();
        news.add(news1);
        news.add(news2);
        for (int i = news.size()-1; i >= 0; i--) {
            System.out.println(news.get(i));
        }

        Iterator<News> iterator = news.iterator();
        while (iterator.hasNext()) {
            News news_ = iterator.next();
            System.out.println(processTitle(news_.getTitle()));
        }
    }

    public static String processTitle(String title) {
        if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        }else {
            return title;
        }

    }
}

class News{
    private String title;
    private String content;

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}