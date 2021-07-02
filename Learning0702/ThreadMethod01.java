package com.wengan.Threaduse;

/**
 * @author 文淦
 * @version 1.0
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.setName("老科");
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
        //主线程打印5个hi  就中断子线程的休眠状态
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("hi" + i);
        }

        System.out.println(t.getName() + "线程的优先级 = " + t.getPriority());

        t.interrupt();

    }
}

class T extends Thread {
    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "吃饺子...");
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中...");
                Thread.sleep(5000);//休眠5秒
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断了...");
            }
        }
    }
}