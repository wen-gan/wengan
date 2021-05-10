//构造器
//
//
public class ConstructorExercise{
	public static void main(String[] args){
		//当我们new 一个对象时，直接通过构造器
		Person p1 = new Person();//无参构造器
		Person p2 = new Person("smith", 80);
		System.out.println("信息如下");
		System.out.println("p1对象 name= " + p1.name + "p1对象 age = " + p1.age);
		System.out.println("p2对象 name= " + p2.name + "p2对象 age = " + p2.age);
	}
}

class Person{
	String name;
	int age;
	//构造器
	//1. 构造器没有返回值，也不能写void
	//2. 构造器的名称和类Person一样
	//3. (String pName, int pAge) 是构造器形参列表，规则和成员方法一样
	public Person(){
		System.out.println("构造器被调用~~ 完成对象的属性初始化");
		age = 18;
	}
	public Person(String pName, int pAge){
		name = pName;
		age = pAge;
	}

}