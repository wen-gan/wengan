package com.wengan.Learning0610.Homework12;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework06 {
    public static void main(String[] args){

        Person person = new Person("唐僧",new Horse());
        person.common();
        person.passRiver();

    }
}

interface Vehicles{
    public void work();
}
class Factory{
    private static Horse horse = new Horse();
    private Factory(){};
    public static Horse getHorse(){
//        return new Horse();
        return horse;
    }
    public static Boat getBoat(){
        return new Boat();
    }
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("一般情况下使用马前进");
    }
}
class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("过河时使用小船");
    }
}
class Person{
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }
    public void passRiver(){
        if(!(vehicles instanceof Boat)){
            vehicles = Factory.getBoat();
        }
        vehicles.work();
    }
    public void common(){
        //判断当前属性vehicle是否已经存在
        if(!(vehicles instanceof Horse)){
            vehicles = Factory.getHorse();
        }
        //接口调用
        vehicles.work();
    }
}