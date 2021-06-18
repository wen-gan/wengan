package com.wengan.Homework;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings("all")
public class Homework01 {
    public static void main(String[] args){
        News news1 = new News("新冠确诊病例超过千万，数百万印度信教徒赴恒河“圣浴”引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        ArrayList arrayList = new ArrayList();
        arrayList.add(news1);
        arrayList.add(news2);
        //打印输出
//        System.out.println(arrayList);

        //倒序输出
        int size = arrayList.size();
        for (int i = size - 1;i >= 0 ;i--) {
//            System.out.println(arrayList.get(i));
            News news = (News) arrayList.get(i);
            System.out.println(processTitle(news.getTitle()));
        }

        //遍历输出
//        for (Object arr : arrayList) {
//            System.out.println(arr);
//        }

//        arrayList.sort(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return
//            }
//        });
    }

    //专门写一个方法，处理显示新闻标题
    public static String processTitle(String title) {
        if (title == null) {
            return "";
        }

        if (title.length() > 15) {
            return title.substring(0, 15) + "..."; //[0, 15)
        } else {
            return title;
        }
    }
}

class News{
    private String title;
    private String content;

    @Override
    public String toString() {
        return "新闻标题：" + title + "\n";
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