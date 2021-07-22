package com.wengan.Consumer_producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author 文淦
 * @version 1.0
 */
public class ProducerConsumer_1 {
    public static final int CAPACITY = 5;
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();

        Thread p1 = new Producer(queue, CAPACITY);
        p1.setName("p1");
        Thread p2 = new Producer(queue, CAPACITY);
        p1.setName("p2");
        Thread p3 = new Producer(queue, CAPACITY);
        p1.setName("p3");

        Thread c1 = new Consumer(queue, CAPACITY);
        c1.setName("c1");
        Thread c2 = new Consumer(queue, CAPACITY);
        c1.setName("c2");
        Thread c3 = new Consumer(queue, CAPACITY);
        c1.setName("c3");

        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
        c3.start();
    }

}

class Producer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;
    private int i = 0;

    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("生产者队列已满，生产者("+Thread.currentThread().getName()+") 线程等待 "+" 消费者对产品进行消费");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //当队列不为空
                System.out.println("生产者 (" + Thread.currentThread().getName() + ") 生产产品：+ " + i);
                queue.offer(i++);
                queue.notifyAll();

                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Consumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    public Consumer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {
                        System.out.println("生产队列已空，消费者(" + Thread.currentThread().getName() + ") 线程等待生产者生产产品");
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int remain = queue.poll();
                System.out.println("消费者 (" + Thread.currentThread().getName() + ") 消费产品：" + remain);
                queue.notifyAll();

                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}