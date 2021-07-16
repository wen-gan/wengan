package com.wengan.Threaduse;

/**
 * @author 文淦
 * @version 1.0
 */
public class SellTicket_2 {
    public static void main(String[] args) {
        sellTicket01 sellTicket = new sellTicket01();

        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
        new Thread(sellTicket).start();
    }
}

class sellTicket01 implements Runnable {
    private static int totalNum = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (this){
                if (totalNum <= 0) {
                    System.out.println("售票结束...");
                    break;
                }

                //进行休眠
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出1张票"
            + "  剩余票数：" + (--totalNum));
        }
    }
}