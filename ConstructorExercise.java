//������
//
//
public class ConstructorExercise{
	public static void main(String[] args){
		//������new һ������ʱ��ֱ��ͨ��������
		Person p1 = new Person();//�޲ι�����
		Person p2 = new Person("smith", 80);
		System.out.println("��Ϣ����");
		System.out.println("p1���� name= " + p1.name + "p1���� age = " + p1.age);
		System.out.println("p2���� name= " + p2.name + "p2���� age = " + p2.age);
	}
}

class Person{
	String name;
	int age;
	//������
	//1. ������û�з���ֵ��Ҳ����дvoid
	//2. �����������ƺ���Personһ��
	//3. (String pName, int pAge) �ǹ������β��б�����ͳ�Ա����һ��
	public Person(){
		System.out.println("������������~~ ��ɶ�������Գ�ʼ��");
		age = 18;
	}
	public Person(String pName, int pAge){
		name = pName;
		age = pAge;
	}

}