//设计一个Dog类，有名字、颜色和年龄属性
//定义输出方法show()显示其信息
//并创建对象，进行测试
public class chapter7Homework07{
	public static void main(String[] args){
		Dog dog1 = new Dog("jack","red",12);
		dog1.show();
	}
}

class Dog {
	String name;
	String color;
	int age;
	public Dog(String name, String color, int age){
		this.name = name;
		this.color = color;
		this.age = age;
	}
	public void show(){
		System.out.println("名字："+name+" 颜色:"+color+" 年龄:"+age);
	}
}