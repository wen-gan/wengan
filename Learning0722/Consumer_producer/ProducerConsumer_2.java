package com.wengan.Consumer_producer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author 文淦
 * @version 1.0
 * 将queue视为产品仓库
 */

public class ProducerConsumer_2 {
    private static final int CAPACITY = 5;//仓库容量
    public static void main(String args[]){
        Queue<Integer> queue = new LinkedList<Integer>();

        Thread producer1 = new Producer(queue, CAPACITY);
        producer1.setName("P1");
        Thread producer2 = new Producer(queue, CAPACITY);
        producer2.setName("P2");
        Thread producer3 = new Producer(queue, CAPACITY);
        producer3.setName("P3");
        Thread consumer1 = new Consumer(queue, CAPACITY);
        consumer1.setName("C1");
        Thread consumer2 = new Consumer(queue, CAPACITY);
        consumer2.setName("C2");
        Thread consumer3 = new Consumer(queue, CAPACITY);
        consumer3.setName("C3");

        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

    static class Producer extends Thread{
        private Queue<Integer> queue;
        int maxSize;
        int i = 0;

        public Producer(Queue<Integer> queue, int maxSize){
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){
            while(true){
                synchronized(queue){//给队列加锁
                    while(queue.size() == maxSize){
                        //当队列满时
                        try {
                            System.out .println("生产队列已满, 生产者 (" + Thread.currentThread().getName() + ") 线程等待 " + "消费者对产品进行消费");
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //队列不为空时
                    System.out.println("生产者 (" + Thread.currentThread().getName() + ") 生产产品 : +" + i);
                    queue.offer(i++);
                    //唤醒所有队列
                    queue.notifyAll();

                    try {
                        Thread.sleep(new Random().nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    static class Consumer extends Thread{
        private Queue<Integer> queue;
        int maxSize;

        public Consumer(Queue<Integer> queue, int maxSize){
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run(){
            while(true){
                synchronized(queue){
                    while (queue.isEmpty()){
                        try {
                            //队列为空时
                            System.out.println("生产队列已空, 消费者 (" + Thread.currentThread().getName() + ") 线程等待生产者生产产品");
                            queue.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    int remain = queue.poll();
                    System.out.println("消费者 (" + Thread.currentThread().getName() + ") 消费产品 : " + remain);
                    //唤醒所有队列
                    queue.notifyAll();

                    try {
                        Thread.sleep(new Random().nextInt(2000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
