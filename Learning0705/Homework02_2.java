package com.wengan.Threaduse.Homework;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02_2 {
    public static void main(String[] args) {

        getMoney getMoney = new getMoney();

        Thread thread1 = new Thread(getMoney);
        thread1.setName("用户1");
        Thread thread2 = new Thread(getMoney);
        thread2.setName("用户2");

        thread1.start();
        thread2.start();
    }
}

class getMoney implements Runnable {
    private double money = 10000;
    private boolean loop = true;

    @Override
    public void run() {

        while (loop) {
            synchronized (this) {
                if (money <= 0) {
                    System.out.println("余额不足...");
                    loop = false;
                    return;
                }

                money -= 1000;
                System.out.println("用户：" + Thread.currentThread().getName() +
                        "  余额：" + money);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}