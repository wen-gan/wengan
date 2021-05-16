package com.wengan.poly_.polyparameter_;

public class PolyParameter {
    public static void main(String[] args){
        Worker tom = new Worker("tom", 2500);
        Manager mike = new Manager("mike", 5000, 200000);
        PolyParameter polyParameter = new PolyParameter();

        polyParameter.showEmpAnnual(tom);
        polyParameter.showEmpAnnual(mike);

        polyParameter.testWork(tom);
        polyParameter.testWork(mike);
    }

    //showEmpAnnual(Employee e)
    public void showEmpAnnual(Employee e) {
        System.out.println(e.getAnnual());//动态绑定机制
    }
    //再增加一个testWork方法
    public void testWork(Employee e){
        if(e instanceof Worker){
            ((Worker) e).work();//有一个向下转型的操作
        }else if(e instanceof Manager){
            ((Manager) e).manage();
        }else{
            System.out.println("不做处理...");
        }
    }
}
