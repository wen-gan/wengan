package com.wengan.Threaduse;

/**
 * @author 文淦
 * @version 1.0
 */
public class ThreadMethodExe {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new T1());
        for (int i = 0; i < 10; i++) {
            System.out.println("hi " + i);
            if (i == 5) {
                //说明主线程输出了5次 hi
                t1.start();//启动子线程 输出hello...
                t1.join();//立即将t1子线程，插入到main，让t1先执行
            }
            Thread.sleep(1000);//输出1次hi，让main线程也休眠1s
        }
    }
}

class T1 implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("hello" + (++count));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (count == 10) {
                break;
            }
        }
    }
}