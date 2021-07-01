package com.wengan.Threaduse;

/**
 * @author 文淦
 * @version 1.0
 */
public class Thread02 {
    public static void main(String[] args){
        Dog dog = new Dog();
        //不能调用start方法
        //这里要创建Thread对象，把dog对象(实现Runnable)，放入Thread
        Thread thread = new Thread(dog);
        thread.start();

        Tiger tiger = new Tiger();//实现了Runnable
        ThreadProxy threadProxy = new ThreadProxy(tiger);
        threadProxy.start();
    }
}

class Animal{}
class Tiger extends Animal implements Runnable{
    @Override
    public void run() {
        System.out.println("老虎嗷嗷叫...");
    }
}

class ThreadProxy implements Runnable {
    private Runnable target = null;//

    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定
        }
    }

    public ThreadProxy(Runnable target) {
        this.target = target;
    }

    public void start(){
        start0();
    }

    public void start0(){
        run();
    }
}

class Dog implements Runnable {//通过实现Runnable接口，开发线程
    int count = 0;
    @Override
    public void run() {//只是一个普通方法，不能实现多线程
        while (true){
            System.out.println("小狗汪汪叫..." + (++count) + Thread.currentThread().getName());

            //休眠1秒
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