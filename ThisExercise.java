//This��ϰ��
//
public class ThisExercise{
	public static void main(String[] args){
		// Person namew = new Person();
		// String name1 = "wengan";
		// String name2 = "gan";
		// if(namew.compareTo(name1,name2)){
		// 	System.out.println("������ͬ");
		// }else {
		// 	System.out.println("���ֲ�ͬ");
	 //    }
		Person p1 = new Person("mary", 20);
		Person p2 = new Person("mary", 20);
		//�����p1Ϊ��ǰ���󣬼�this��ָ�Ķ���;p2Ϊ���ȽϵĶ��󣬼�p����
		System.out.println("p1��p2�ȽϵĽ��"+p1.compareTo(p2));
	}
}

class Person {
	String name;
	int age;
	//���幹����
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	//����ȽϷ���
	public boolean compareTo(Person p){
		if(this.name.equals(p.name) && this.age == p.age){
			return true;
		}else{
			return false;
		}
	}
}
