//在B类中编写一个方法test100，可以接受一个数组，
//在方法中修改该数组，看看原来的数组是否变化
//在B类中编写一个方法test200，可以接受一个Person(age,sal)对象，
//在方法中修改该对象的属性，看看原来的对象是否变化
public class MethodExercise02{
	public static void main(String[] args){
		B b = new B();
		int[] arr = {1,2,3};
		b.test100(arr);
		System.out.println("main 的 arr1 数组");
		//遍历数组
		for(int i=0; i<arr.length ; i++){
			System.out.print(arr[i] + "\t");
		}
		System.out.println();	
		//测试
		Person p = new Person();
		p.name = "jack";
		p.age = 10;

		b.test200(p);
		System.out.println("main方法的 p.age= " + p.age);//10000
}

class Person{
	String name;
	int age;
}

class B{
	public void test200(Person p){
		p.age = 10000;
	}
	public void test100(int[] arr1){
		arr1[0] = 200;
		//遍历数组
		System.out.println("test100 的 arr1 数组");
		for(int i=0; i<arr1.length ; i++){
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
	}
}