//���һ��Dog�࣬�����֡���ɫ����������
//�����������show()��ʾ����Ϣ
//���������󣬽��в���
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
		System.out.println("���֣�"+name+" ��ɫ:"+color+" ����:"+age);
	}
}