//1)��дһ��MyTool��
//  ��дһ���������Դ�ӡ��ά���������
//2)��дһ������copyPerson,���Ը���һ��Person���󣬷��ظ��ƵĶ���
//  ��¡����ע��Ҫ��õ��¶����ԭ���Ķ��������������Ķ���
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

		//����p��p2��������������Person����������ͬ
		System.out.println("p ������ age = " + p.age +" ����= " + p.name);
		System.out.println("p2������ age = " + p2.age +" ����= " + p2.name);
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
		p2.name = p.name;//��ԭ����������ָ���p2.name
		p2.age = p.age;//��ԭ����������丳��p2.age

		return p2;
	}
}
