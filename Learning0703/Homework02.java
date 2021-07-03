package com.wengan.Threaduse.Homework;

/**
 * @author 文淦
 * @version 1.0
 *
 * 有两个用户分别从同一个卡上取钱(总金额：10000)
 * 每次都取1000，当余额不足时不能再取款了
 * 不能出现超取现象  ====>  线程同步问题
 */
public class Homework02 {
    public static void main(String[] args) {
        getPrice getPrice = new getPrice();
        Thread thread1 = new Thread(getPrice);
        thread1.setName("t1");
        Thread thread2 = new Thread(getPrice);
        thread2.setName("t2");

        thread1.start();
        thread2.start();
    }
}

class getPrice implements Runnable {
    private int total = 10000;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop){

            synchronized (this) {
                if (total <= 0) {
                    System.out.println("余额不足...");
                    loop = false;
                    return;
                }

                total -= 1000;

                System.out.println("用户：" + Thread.currentThread().getName() + "取出1000元" +
                        "  余额：" + total);
            }

            //休眠
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
