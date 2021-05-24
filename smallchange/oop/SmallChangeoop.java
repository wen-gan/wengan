package com.wengan.smallchange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeoop {
    boolean loop = true;//用于控制显示菜单
    Scanner scanner = new Scanner(System.in);
    String key = "";
    String details = "---------------零钱通明细---------------";
    double money = 0;
    double balance = 0;
    Date date = null;//date 是 java.util.Date类型，表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化的
    String note = "";

    public void mainMenu(){
        do{
            System.out.println("---------------零钱通菜单(OOP)---------------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消      费");
            System.out.println("\t\t\t4 退      出");

            System.out.print("请选择(1-4): ");
            key = scanner.next();

            //使用switch分支
            switch (key){
                case "1":
                    this.details();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.consume();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }while (loop);
        System.out.println("---------------退出了零钱通项目---------------");
    }
    public void details(){
        System.out.println(details);
    }
    public void income(){
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();
        //money 的值范围应该校验
        //找出不正确金额的条件并给出提示即可，就直接break
        if(money <= 0){
            System.out.println("收益入账金额范围需要大于0");
            return;
        }
        balance += money;
        //拼接收益入账信息到details
        date = new Date();//获取到当前的日期
        details +=  "\n收益入账\t+"+money+"\t"+ sdf.format(date) + "\t" + balance;
        System.out.println(details);
    }
    public void consume(){
        System.out.println("收益消费金额：");
        money = scanner.nextDouble();
        if(money > balance || money <= 0){
            System.out.println("余额不足，请重新输入：");
            return;
        }
        //money 的值范围应该要校验
        System.out.println("消费说明：");
        note = scanner.next();
        date = new Date();//获取当前时间
        balance -= money;
        //拼接消费信息到details
        details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
        System.out.println(details);
    }
    public void exit(){
        String choice = "";
        while(true){
            System.out.println("你确定要退出吗？y/n");
            choice = scanner.next();
            if("y".equals(choice) || "n".equals(choice)){
                break;
            }
        }
        //当用户退出while 后就进行判断
        if(choice.equals("y")){
            loop = false;
        }
    }
}
