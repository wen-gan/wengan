//�ж�һ���Ƿ�Ϊ����
//
import java.util.Scanner;
public class chapter5Homework03{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("���������");
		int year = myscanner.nextInt();
		if((year%4==0 && year%100!=0) || year%400==0){
			System.out.println(year + "������");
		}else{
			System.out.println(year + "��������");
		}
	}
}