package com.wengan.live;

public class HouseMaster extends HouQin{
    public HouseMaster(String name, String gender, int phonenum, String nativeplace, String hobby, String zaibian, String feizaibian) {
        super(name, gender, phonenum, nativeplace, hobby, zaibian, feizaibian);
    }

    @Override
    public void protect() {
        super.protect();
        System.out.println("宿管"+getName()+"正在查寝...");
    }
}
