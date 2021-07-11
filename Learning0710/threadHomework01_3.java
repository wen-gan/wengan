package com.wengan.Threaduse.Homework;

import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework01_3 {
    public static void main(String[] args) {
        A3 a3 = new A3();
        B3 b3 = new B3(a3);

        a3.start();
        b3.start();
    }
}
@SuppressWarnings({"all"})
class A3 extends Thread{
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

    public void setLoop(boolean loop) {this.loop = loop;}
}

class B3 extends Thread {
    private A3 a3;
    Scanner scanner = new Scanner(System.in);

    public B3(A3 a3) {
        this.a3 = a3;
    }

    @Override
    public void run() {
        System.out.println("输入w以结束");
        while (true){
            char key = scanner.next().toUpperCase().charAt(0);

            if (key == 'W') {
                a3.setLoop(false);
                System.out.println("b3线程退出");
                break;
            }
        }
    }
}