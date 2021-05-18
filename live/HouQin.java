package com.wengan.live;

public class HouQin extends Person{
    private String zaibian;
    private String feizaibian;

    public HouQin(String name, String gender, int phonenum, String nativeplace, String hobby, String zaibian, String feizaibian) {
        super(name, gender, phonenum, nativeplace, hobby);
        this.zaibian = zaibian;
        this.feizaibian = feizaibian;
    }

    public String getZaibian() {
        return zaibian;
    }

    public void setZaibian(String zaibian) {
        this.zaibian = zaibian;
    }

    public String getFeizaibian() {
        return feizaibian;
    }

    public void setFeizaibian(String feizaibian) {
        this.feizaibian = feizaibian;
    }
    //后勤人员的方法 后勤保障
    public void protect(){
        System.out.println(getName()+"正在进行后勤保障...");
    }
}
