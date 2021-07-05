package com.wengan.Threaduse.Homework;

import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class Homework01_2 {
    public static void main(String[] args) {
        A1 a1 = new A1();
        B1 b1 = new B1(a1);

        a1.start();
        b1.start();
    }
}

class A1 extends Thread {
    private boolean loop = true;
    @Override
    public void run() {
        while (loop) {

            System.out.println((int)(Math.random() * 100 + 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {//可以修改loop变量
        this.loop = loop;
    }
}

class B1 extends Thread {
    private A1 a1;
    private Scanner scanner = new Scanner(System.in);

    public B1(A1 a1) {
        this.a1 = a1;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("输入Q以结束线程");
            char key = scanner.next().toUpperCase().charAt(0);
            if (key == 'Q') {
                a1.setLoop(false);
                System.out.println("b线程退出...");
                break;
            }
        }
    }
}