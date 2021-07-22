package com.wengan.Consumer_producer;

import java.util.Random;

/**
 * @author 文淦
 * @version 1.0
 */
public class ProducerConsumer_0 {
    private static int count = 0;
    private static int CAPACITY = 10;
    private static String WAREHOUSE = "WAREHOUSE";

    public static void main(String[] args) {

        Thread producer1 = new Thread(new Producer());
        producer1.setName("P1");
        Thread producer2 = new Thread(new Producer());
        producer2.setName("P2");
        Thread producer3 = new Thread(new Producer());
        producer3.setName("P3");

        Thread consumer1 = new Thread(new Consumer());
        consumer1.setName("C1");
        Thread consumer2 = new Thread(new Consumer());
        consumer2.setName("C2");
        Thread consumer3 = new Thread(new Consumer());
        consumer3.setName("C3");

        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }
    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (WAREHOUSE) {
                    while (count == CAPACITY) {
                        try {
                            WAREHOUSE.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //当生产序列没满时
                    count++;
                    System.out.println("生产者" + Thread.currentThread().getName() + "进行生产，目前总共有产品" + count + "个");
                    WAREHOUSE.notifyAll();

                }
            }
        }
    }
    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (WAREHOUSE) {
                    while (count == 0) {
                        try {
                            WAREHOUSE.wait();
                        } catch (Exception e) {
                        }
                    }
                    //当生产序列有产品时
                    count--;
                    System.out.println("消费者" + Thread.currentThread().getName() + "进行消费，目前总共有产品" + count + "个");
                    WAREHOUSE.notifyAll();

                }
            }
        }
    }
}