package com.wengan.Learning0619;

import java.util.ArrayList;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework01_2 {
    public static void main(String[] args) {
        ArrayList<News> news = new ArrayList<>();
        news.add(new News("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”，引民众担忧"));
        news.add(new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));

        int len = news.size();
        //倒序遍历
        for (int i = len-1; i >= 0; i--) {
            News news1 = (News) news.get(i);
            System.out.println(processTitle(news1.getTitle()));
        }

    }

    public static String processTitle(String title){
        if (title.length() > 15) {
            return title.substring(0, 15) + "...";
        }else {
            return title;
        }
    }
}

class News {
    private String title;
    private String content;

    @Override
    public String toString() {
        return title;
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