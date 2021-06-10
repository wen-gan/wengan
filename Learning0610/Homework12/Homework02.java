package com.wengan.Learning0610.Homework12;

/**
 * @author 文淦
 * @version 1.0
 */
public class Homework02 {

}

class Frock{
    private static int currentNum = 100000;
    private int serialNumber;

    public Frock() {
        this.serialNumber = Frock.getNextNum();
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum(){
        return currentNum+=100;
    }
}

class TestFrock{
    public static void main(String[] args){
        int n1 = Frock.getNextNum();
        System.out.println(n1);
        int n2 = Frock.getNextNum();
        System.out.println(n2);

        Frock frock1 = new Frock();
        System.out.println(frock1.getSerialNumber());
        Frock frock2 = new Frock();
        System.out.println(frock2.getSerialNumber());
        Frock frock3 = new Frock();
        System.out.println(frock3.getSerialNumber());
    }
}