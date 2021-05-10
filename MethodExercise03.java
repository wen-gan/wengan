//1)编写一个MyTool类
//  编写一个方法可以打印二维数组的数据
//2)编写一个方法copyPerson,可以复制一个Person对象，返回复制的对象
//  克隆对象，注意要求得到新对象和原来的对象是两个独立的对象
public class MethodExercise03{
	public static void main(String[] args){
		MyTool mytool = new MyTool();
		int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
		mytool.print(arr);

		Person p = new Person();
		p.name = "gan";
		p.age = 100;

		MyTool tool = new MyTool();
		Person p2 = tool.copyPerson(p);

		//到此p和p2都是两个独立的Person对象，属性相同
		System.out.println("p 的属性 age = " + p.age +" 名字= " + p.name);
		System.out.println("p2的属性 age = " + p2.age +" 名字= " + p2.name);
	}
}

class Person{
	String name;
	int age;
}

class MyTool{
	public void print(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[i].length;j++){
				System.out.println(arr[i][j] + " ");
			}
		}
	}

	public Person copyPerson(Person p){
		Person p2 = new Person();
		p2.name = p.name;//把原来对象的名字赋给p2.name
		p2.age = p.age;//把原来对象的年龄赋给p2.age

		return p2;
	}
}
