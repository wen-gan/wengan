package com.wengan.Threaduse;

/**
 * @author 文淦
 * @version 1.0
 */
public class Thread03 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        T4 t4 = new T4();
        Thread thread3 = new Thread(t3);
        Thread thread4 = new Thread(t4);

        thread3.start();
        thread4.start();

        System.out.println("main线程继续执行...");
    }
}

class T3 implements Runnable{
    int n = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello " + (n++) + Thread.currentThread().getName());

            if (n == 10) {
                break;
            }
        }

    }
}

class T4 implements Runnable {
    int n = 0;

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hi " + (n++) + Thread.currentThread().getName());

            if (n == 10) {
                break;
            }
        }

    }
}