package com.wengan.Threaduse.Homework;

import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 *
 * 在main方法中启动两个线程
 * 第1个线程循环随机打印了100以内的整数
 * 直到第2个线程从键盘读取了"Q"命令
 */
public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);//必须把a传进B
        a.start();
        b.start();
    }
}

//创建A线程
class A extends Thread {
    private boolean loop = true;

    @Override
    public void run() {
        //输出1-100的数字
        while (loop) {
            System.out.println((int)(Math.random() * 100 + 1));

            //休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {//可以修改loop变量
        this.loop = loop;
    }
}

class B extends Thread {
    private A a;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {

        while (true) {
            //接收到用户的输入
            System.out.println("请输入指令(Q)表示退出：");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                a.setLoop(false);
                System.out.println("b线程退出...");
                break;
            }
        }

    }
}