//创建一个Employee类
//属性有(名字、性别、年龄、职位、薪水)
//提供3个构造方法，可以初始化
//(1)(名字，性别，年龄，职位，薪水)
//(2)(名字，性别，年龄)
//(3)(职位，薪水)
//要求充分复用构造器
public class chapter7Homework12{
	public static void main(String[] args){

	}
}

class Employee {
	String name;
	String gender;
	int age;
	String job;
	double salary;
	//因为要复用构造器，因此先写属性少的构造器
	public Employee(String job,double salary){
		this.job = job;
		this.salary = salary;
	}
	public Employee(String name,String gender,int age){
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	public Employee(String name,String gender,int age,String job,double salary){
		this(name, gender, age);//使用到前面的构造器
		this.job = job;
		this.salary = salary;
	}
}