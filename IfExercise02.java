//if����ʹ��
import java.util.Scanner;
public class IfExercise02{
	public static void main(String[] args){
	Scanner myscanner = new Scanner(System.in);
	System.out.println("���û���ֵ(1-100)�� ");
	double d1 = myscanner.nextDouble();
	if (d1 >= 1 && d1 <= 100){
		if(d1 == 100){
			System.out.println("���ü���");
		}else if (d1 > 80 && d1 <= 99) {
			System.out.println("��������");
		}else if (d1 > 60 && d1 <= 80) {
			System.out.println("����һ��");
		}else {
			System.out.println("���ò�����");
		}
	}else{
		System.out.println("������������������1-100�����û���");
	}
	}
}