//if-else��ϰ
//
//
import java.util.Scanner;
public class IfExercise01{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("�������1������");
		double d1 = myscanner.nextDouble();
		System.out.println("�������2������");
		double d2 = myscanner.nextDouble();
		if(d1 > 10.0 && d2 < 20.0){
			System.out.println("�������ĺ�"+(d1+d2));
		}else{
			System.out.println("�������Ĳ�"+(d1-d2));
		}

		//�ж�һ������Ƿ�Ϊ���꣬���������������֮һ��
		//(1)����ܱ�4�����������ܱ�100������(2)�ܱ�400����
		System.out.println("��������ݣ�");
		int year = myscanner.nextInt();
		if((year % 4 ==0 && year % 100 != 0) || year % 400 ==0){
			System.out.println(year + "������");
		}else{
			System.out.println(year + "��������");
		}
	}
}