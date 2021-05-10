//This练习题
//
public class ThisExercise{
	public static void main(String[] args){
		// Person namew = new Person();
		// String name1 = "wengan";
		// String name2 = "gan";
		// if(namew.compareTo(name1,name2)){
		// 	System.out.println("名字相同");
		// }else {
		// 	System.out.println("名字不同");
	 //    }
		Person p1 = new Person("mary", 20);
		Person p2 = new Person("mary", 20);
		//这里的p1为当前对象，即this所指的对象;p2为被比较的对象，即p对象
		System.out.println("p1和p2比较的结果"+p1.compareTo(p2));
	}
}

class Person {
	String name;
	int age;
	//定义构造器
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	//定义比较方法
	public boolean compareTo(Person p){
		if(this.name.equals(p.name) && this.age == p.age){
			return true;
		}else{
			return false;
		}
	}
}
