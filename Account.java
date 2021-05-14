package com.wengan.encapsulation;

public class Account {
    private String name;
    private double balance;
    private String pwd;

    //提供两个构造器
    //首先建立无参构造器
    public Account(){

    }

    public Account(String name,double balance,String pwd){
        this.setName(name);
        this.setBalance(balance);
        this.setPwd(pwd);
    }

    public String getName() {
        return name;
    }
    //姓名长度是2/3/4
    public void setName(String name) {
        if(name.length()>=2 && name.length()<=4) {
            this.name = name;
        }else{
            System.out.println("名字要求在2-4个字符范围内，默认值为无名");
            this.name = "无名";
        }
    }

    public double getBalance() {
        return balance;
    }
    //余额不能小于20
    public void setBalance(double balance) {
        if(balance>20) {
            this.balance = balance;
        }else{
            System.out.println("余额已经小于20，默认为0");
            this.balance = 0;
        }
    }

    public String getPwd() {
        return pwd;
    }
    //密码必须为6位
    public void setPwd(String pwd) {
        if(pwd.length() == 6) {
            this.pwd = pwd;
        }else{
            System.out.println("密码必须为6位数");
            this.pwd = "000000";
        }
    }
    //显示账号信息
    public void show(){
        //可以增加权限的校验
        System.out.println("姓名："+name+" 账户余额："+balance+" 密码："+pwd);
    }
}
