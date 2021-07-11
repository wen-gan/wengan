package com.wengan.Threaduse.Homework;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02_3 {
    public static void main(String[] args) {
        getMoney01 getMoney01 = new getMoney01();

        Thread thread1 = new Thread(getMoney01);
        thread1.setName("老王");
        Thread thread2 = new Thread(getMoney01);
        thread2.setName("老张");

        thread1.start();
        thread2.start();
    }
}

class getMoney01 implements Runnable {
    private boolean loop = true;
    private int cash = 10000;

    @Override
    public void run() {
        while (loop) {
            synchronized (this) {
                if (cash <= 0) {
                    System.out.println("没钱了...");
                    loop = false;
                    return;
                }

                cash -= 500;

                System.out.println("员工" + Thread.currentThread().getName() + "消费500  " +
                        "余额: " + cash);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}