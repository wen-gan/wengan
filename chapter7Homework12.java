//����һ��Employee��
//������(���֡��Ա����䡢ְλ��нˮ)
//�ṩ3�����췽�������Գ�ʼ��
//(1)(���֣��Ա����䣬ְλ��нˮ)
//(2)(���֣��Ա�����)
//(3)(ְλ��нˮ)
//Ҫ���ָ��ù�����
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
	//��ΪҪ���ù������������д�����ٵĹ�����
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
		this(name, gender, age);//ʹ�õ�ǰ��Ĺ�����
		this.job = job;
		this.salary = salary;
	}
}