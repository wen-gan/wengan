//��B���б�дһ������test100�����Խ���һ�����飬
//�ڷ������޸ĸ����飬����ԭ���������Ƿ�仯
//��B���б�дһ������test200�����Խ���һ��Person(age,sal)����
//�ڷ������޸ĸö�������ԣ�����ԭ���Ķ����Ƿ�仯
public class MethodExercise02{
	public static void main(String[] args){
		B b = new B();
		int[] arr = {1,2,3};
		b.test100(arr);
		System.out.println("main �� arr1 ����");
		//��������
		for(int i=0; i<arr.length ; i++){
			System.out.print(arr[i] + "\t");
		}
		System.out.println();	
		//����
		Person p = new Person();
		p.name = "jack";
		p.age = 10;

		b.test200(p);
		System.out.println("main������ p.age= " + p.age);//10000
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
		//��������
		System.out.println("test100 �� arr1 ����");
		for(int i=0; i<arr1.length ; i++){
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
	}
}