package com.wengan.Threaduse.Syn;

/**
 * @author 文淦
 * @version 1.0
 */
public class DeadLock_2 {
    public static void main(String[] args) {
        DeadLockDe A = new DeadLockDe(true);
        A.setName("A线程");
        DeadLockDe B = new DeadLockDe(false);
        B.setName("B线程");

        A.start();
        B.start();

    }
}

class DeadLockDe extends Thread {
    static Object o1 = new Object();
    static Object o2 = new Object();
    boolean flag;

    public DeadLockDe(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + "进入线程1");
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "进入线程2");
                }
            }
        }else {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + "进入线程3");
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "进入线程4");
                }
            }
        }
    }
}