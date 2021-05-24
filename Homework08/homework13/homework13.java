package com.wengan.Homework.homework13;

public class homework13 {
    public static void main(String[] aegs){
        Person persons[] = new Person[4];
        persons[0] = new Student("jack", "男", 34, 130299);
        persons[1] = new Student("mike", "男", 21, 130300);
        persons[2] = new Teacher("jane", "女", 40, 30);
        persons[3] = new Teacher("john", "男", 32, 18);
        //按照年龄排序  冒泡排序
        Person temp = null;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - 1 - i; j++) {
                if(persons[j].getAge() < persons[j+1].getAge()){
                    temp = persons[j+1];
                    persons[j+1] = persons[j];
                    persons[j] = temp;
                }
            }
        }
        M m = new M();
        for (int i = 0; i < persons.length; i++) {
            persons[i].info();
            m.method(persons[i]);
            System.out.println(persons[i].play());
            System.out.println("========================");
        }

    }

}
class M{
    public void method(Person p){
        if(p instanceof Student){
            ((Student) p).study();
        }else if(p instanceof Teacher){
            ((Teacher) p).teach();
        }
    }
}
