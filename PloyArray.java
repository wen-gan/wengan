package com.wengan.poly_.polyarr_;

public class PloyArray {
    public static void main(String[] args){
        //应用实例：现有一个集成结构，要求创建1个Person对象
        //2个Student 对象和2个Teacher对象，统一放在数组中，并调用每个对象的say()方法
        Person[] persons = new Person[5];
        persons[0] = new Person("jack",20);
        persons[1] = new Student("tom",18,100);
        persons[2] = new Student("mike",19,60.5);
        persons[3] = new Teacher("scott",30,20000);
        persons[4] = new Teacher("tony",50,50000);

        //循环遍历多态数组，调用say()方法
        for (int i = 0; i < persons.length; i++) {
            //person[i]的编译类型是 Person ,运行类型是根据实际情况在JVM机来判断
            System.out.println(persons[i].say());//动态绑定机制
            //要调用在Teacher 和 Student类里面的特有的方法
            if(persons[i] instanceof Student){
                //首先判断persons[i]是不是学生类型
                //如果是就进行类型强转
                Student student = (Student)persons[i];//向下转型
                student.study();
                //也可以使用一条语句实现
                //((Student)persons[i]).study();
            }else if(persons[i] instanceof Teacher){
                Teacher teacher = (Teacher)persons[i];//向下转型
                teacher.teach();
            }else if(persons[i] instanceof Person){
                //System.out.println("你的类型有误，请检查...");
            }else {
                System.out.println("你的类型有误，请检查...");
            }
        }
    }
}
