//����һ��Բ��Cricle
//������Ϊ�뾶
//�ṩ��ʾԲ�ܳ����ܵķ���
//�ṩ��ʾԲ����ķ���
public class chapter7Homework05{
	public static void main(String[] args){
		Circle circle = new Circle(3.0);
		System.out.println("��Բ���ܳ�Ϊ��" + circle.Perimeter());
		System.out.println("��Բ�����Ϊ��" + circle.area());
	}
}

class Circle {
	double r;
	public Circle(double r){
		this.r = r;
	}
	public double Perimeter(){
		return 2*Math.PI*this.r;
	}
	public double area(){
		return Math.PI*this.r*this.r;
	}
}