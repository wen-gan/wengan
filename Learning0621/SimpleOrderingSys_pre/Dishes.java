package com.wengan.Learning0621.SimpleOrderingSys2;

/**
 * @author 文淦
 * @version 1.0
 */
public class Dishes {
    private String name;
    private double Spe;
    private int nums;

    @Override
    public String toString() {
        return  name +
                " " + Spe +
                " " + nums ;
    }

    public Dishes(String name, double spe, int nums) {
        this.name = name;
        Spe = spe;
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpe() {
        return Spe;
    }

    public void setSpe(double spe) {
        Spe = spe;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}

enum Dishs {
    DUMPLING1("素三鲜水饺", 12,1), DUMPLING2("酸菜油吱啦", 12,1), PORK("猪肉", 16,1), DUMPLING3("汤饺(肉)", 7,1), DUMPLING4("汤饺(素)", 5,1),
    RICE1("米饭(小碗)", 2,1), RICE2("米饭(大碗)", 3,1), NOODLES1("面条(小碗)",2,1), NOODLES2("面条(中碗)",3,1),NOODLES3("面条(大碗)",4,1),
    BEAN1("饹豆子(小碗)", 2,1), BEAN2("饹豆子(大碗)", 3,1), EGGNOODLES("鸡蛋炒面", 6,1), HAMNOODLES("火腿炒面", 6,1), MEATNODDLES("肉炒面", 7,1),
    EGGRICE("蛋炒饭", 6,1), YANGRICE("扬州炒饭", 7,1), DANNOODELS1("担担面(小碗)", 4,1), DANNOODELS2("担担面(大碗)", 5,1), LIFISH("鲤鱼(豆瓣、红烧、家炖)", 30,1),
    DAOFISH("刀鱼(干炸、红烧、家炖)", 16,1), HUANGFISH("小黄花鱼(干炸、干煎)", 30,1), QINGFISH("青鱼", 30,1);

    private String name;
    private int spe;
    private int times;

    Dishs(String name, int spe, int times) {
        this.name = name;
        this.spe = spe;
        this.times = times;
    }

    @Override
    public String toString() {
        return  name +
                "\t" + spe +
                "\t" + times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpe() {
        return spe;
    }

    public void setSpe(int spe) {
        this.spe = spe;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}