package com.wengan.Homework;

import java.util.Scanner;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework {
    public static void main(String[] args) {

        A a = new A();
        B b = new B(a);

        Thread client = new Thread(a);
        Thread server = new Thread(b);

        client.start();
        server.start();

    }
}

class A implements Runnable{
    private boolean loop = true;

    @Override
    public void run() {

        while (loop) {
            System.out.println((int) (Math.random() * 100 + 1));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}

class B implements Runnable {
    private A a;
//    private boolean loop;
    private Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        System.out.println("请输入Q以停止：");
        char key = scanner.next().toUpperCase().charAt(0);

        while (true) {

            if (key == 'Q') {
                a.setLoop(false);
                break;
            }
        }
    }
}