package com.wengan.live;

public class Securitystaff extends HouQin{
    public Securitystaff(String name, String gender, int phonenum, String nativeplace, String hobby, String zaibian, String feizaibian) {
        super(name, gender, phonenum, nativeplace, hobby, zaibian, feizaibian);
    }

    @Override
    public void protect() {
        super.protect();
        System.out.println("保安"+getName()+"正在巡逻");
    }
}
