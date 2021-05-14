package com.wengan.super_;

public class Super01 {
    public static void main(String[] args){
        B b = new B();
        b.sum();
    }
}
class A{
    //4个属性
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;

    public A(){}
    public A(String name) {}
    public A(String name, int age){}

    public void cal(){
        System.out.println("A类的cal()方法...");
    }
    public void test100(){

    }
    protected void test200(){

    }
    void test300(){

    }
    private void test400(){

    }
}
class B extends A{
    public void hi(){
        //不能访问父类private属性
        System.out.println(super.n1 +" "+super.n2+" "+super.n3+"");
    }
    public void sum(){
        System.out.println("B类的sum()");
        //希望调用父类A的cal方法的方式
        //这时因为子类B没有cal方法，因此可以使用下面三种方式
        //找cal方法时，顺序为：先找本类，如果有且可以调用就调用；反之则找父类(父类如果有)；父类如果没有就找父类的父类
        //如果实在没找到就提示方法不存在
        //cal();
        //this.cal();//等价于cal()
        super.cal();//找cal的顺序是直接查找父类的（不会找子类的cal），其他的逻辑规则和前面一样
    }
    public void ok(){
        //不能访问父类private方法
        super.test100();
        super.test200();
        super.test300();
    }
}