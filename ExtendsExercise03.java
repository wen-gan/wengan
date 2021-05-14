package com.wengan.extend.exercise;

public class ExtendsExercise03 {
    public static void main(String[] args){
        PC pc = new PC("intel",16,500,"IBM");
        pc.printInfo();

    }
}
class Computer{
    private String cpu;
    private int memory;
    private int disk;

    public Computer(String cpu, int memory, int disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }
    //返回Computer信息
    public String getDetails(){
        return "cpu=" + cpu +" memory=" + memory + " disk=" + disk;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }
}


class PC extends Computer{
    private String brand;
    //这里IDEA根据继承的规则，自动把构造器的调用写好
    //子类的构造器完成子类属性初始化
    public PC(String cpu, int memory, int disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void printInfo(){
        System.out.println("PC信息=");
//        System.out.println(getCpu() + getMemory() + getDisk());
        //调用父类的getDetails方法
        System.out.println(getDetails() + "brand=" + brand);
    }
}
class NotePad extends Computer{
    private String color;

    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }
}
