package com.wengan.Threaduse;

/**
 * @author 文淦
 * @version 1.0
 */
public class Thread01 {
    public static void main(String[] args){
        //创建一个Cat对象，作为线程使用
        Cat cat = new Cat();
        //启动线程
        cat.start();

    }
}

//当继承了Thread类，该类就可以当做线程使用
class Cat extends Thread{
    int times = 0;
    //将run方法内部写成自己需要实现的业务逻辑
    @Override
    public void run() {
        while (true) {
            System.out.println("喵喵，我是小猫咪" + (++times) + " 线程名=" + Thread.currentThread().getName());
            //让线程休眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (times == 8) {
                break;//当times=8就退出while循环，同时退出线程
            }
        }
    }
}