package com.wengan.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    //1.先完成显式菜单，并可以选择菜单，给出对应提示
    //2.完成零钱通明细：(1)可以把收益入账和消费保存到数组(2)可以使用对象(3)简单的话可以使用String拼接
    //3.完成收益入账   定义新的变量和代码
    //4.消费  定义新变量，保存消费的原因
    //5.在用户输入4退出时，给出提示"你确定要退出吗？y/n"，且必须输入正确的y/n，否则循环输入指令，直到输入正确的y/n
    public static void main(String[] args){
        boolean loop = true;//用于控制显示菜单
        Scanner scanner = new Scanner(System.in);
        String key = "";
        String details = "---------------零钱通明细---------------";
        double money = 0;
        double balance = 0;
        Date date = null;//date 是 java.util.Date类型，表示日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化的
        String note = "";
        do{
            System.out.println("---------------零钱通菜单---------------");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消      费");
            System.out.println("\t\t\t4 退      出");

            System.out.print("请选择(1-4): ");
            key = scanner.next();

            //使用switch分支
            switch (key){
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.println("收益入账金额：");
                    money = scanner.nextDouble();
                    //money 的值范围应该校验
                    //找出不正确金额的条件并给出提示即可，就直接break
                    if(money <= 0){
                        System.out.println("收益入账金额范围需要大于0");
                        break;
                    }
                    balance += money;
                    //拼接收益入账信息到details
                    date = new Date();//获取到当前的日期
                    details +=  "\n收益入账\t+"+money+"\t"+ sdf.format(date) + "\t" + balance;
                    System.out.println(details);
                    break;
                case "3":
                    System.out.println("收益消费金额：");
                    money = scanner.nextDouble();
                    if(money > balance || money <= 0){
                        System.out.println("余额不足，请重新输入：");
                        break;
                    }
                    //money 的值范围应该要校验
                    System.out.println("消费说明：");
                    note = scanner.next();
                    date = new Date();//获取当前时间
                    balance -= money;
                    //拼接消费信息到details
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;
                    System.out.println(details);
                    break;
                case "4":
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

                    break;
                default:
                    System.out.println("选择有误，请重新选择");
            }
        }while (loop);

        System.out.println("---------------退出了零钱通项目---------------");
    }
}
