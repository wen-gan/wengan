//ʵ���ж�һ�����������ĸ���Χ
//����0��С��0������0
import java.util.Scanner;
public class chapter5Homework02{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("������������ ");
		int i = myscanner.nextInt();
		if(i>0){
			System.out.println("��������0");
		}else if(i < 0){
			System.out.println("����С��0");
		}else{
			System.out.println("��������0");
		}
	}
}