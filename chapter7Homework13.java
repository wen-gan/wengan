//(1)����һ��Circle�࣬����һ��double�͵�radius���Դ���Բ�İ뾶
//   findArea()��������Բ�����
//(2)����һ����PassObject�������ж���һ������printAreas()
//   �÷�������Ϊpublic void printAreas(Circle c,int times)
//(3)��printAreas�����д�ӡ���1��times֮���ÿ�������뾶ֵ
//   �Լ���Ӧ���������timesΪ5������뾶1,2,3,4,5�Լ���Ӧ��Բ���
//(4)��main�����е���printAreas()������������Ϻ������ǰ�뾶ֵ
public class chapter7Homework13{
	public static void main(String[] args){
		Circle c = new Circle();
		PassObject po = new PassObject();
		po.printAreas(c,5);
	}
}

class Circle {
	double radius;
	public Circle(){//�����޲ι�����

	}
	public Circle(double radius){
		this.radius = radius;
	}

	public double findArea(){//�������
		return Math.PI*this.radius*this.radius;
	}
	//��ӷ���setRadius���޸Ķ���İ뾶ֵ
	public void setRadius(double radius){
		this.radius = radius;
	}
}

class PassObject {
	public void printAreas(Circle c,int times){
		System.out.println("radius\tarea");
		for(int i=1;i<=times;i++){//���1��times֮���ÿ�������뾶ֵ
			c.setRadius(i);//�޸�c ����İ뾶ֵ
			System.out.println((double)i+"\t"+c.findArea());
		}
	}
}