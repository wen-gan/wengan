package com.wengan.Learning0612;

import java.util.concurrent.Semaphore;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework06_exercise2 {
    public static void main(String[] args){
        Person tang = new Person("唐僧", new Horse());
        tang.common();
        tang.passRiver();
    }
}

interface Vehicles{
    public void work();
}

class Horse implements Vehicles{
    @Override
    public void work() {
        System.out.println("平常情况下骑马");
    }
}

class Boat implements Vehicles{
    @Override
    public void work() {
        System.out.println("遇到河时划船");
    }
}

class Factory{
    public static Horse getHorse(){
        return new Horse();
    }

    public static Boat getBoat(){
        return new Boat();
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
        if(!(vehicles instanceof Horse)){
            vehicles = Factory.getHorse();
        }
        vehicles.work();
    }
}