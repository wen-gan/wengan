//��Ʊϵͳ
//4-10��Ϊ����������(18-60)60����ͯ(<18)��ۣ�����(>60)20;
//����������40������20
//1.ȷ������
//2.ȷ������
//3.ȷ��Ʊ��
import java.util.Scanner;
public class IfExercise03{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("�������·ݣ� ");
		double month = myscanner.nextDouble();
		//��ʼ�ж����
		if(month >= 4 && month <= 10){//����
			System.out.println("���������䣺 ");
		    int age1 = myscanner.nextInt();
			if(age1 >= 18 && age1 <= 60){
				System.out.println("Ʊ��Ϊ 60 Ԫ");
			}else if(age1 < 18) {
				System.out.println("Ʊ��Ϊ 30 Ԫ");
			}else if(age1 > 60){
				System.out.println("Ʊ��Ϊ 20 Ԫ");
			}else if(age1 <= 0){
				System.out.println("������˼�������������");
			}
		}else if((month >= 1 && month < 4) || (month > 10 && month <= 12)){//����
			System.out.println("���������䣺 ");
		    int age2 = myscanner.nextInt();
		    if(age2 >= 18 && age2 <= 60){
		    	System.out.println("Ʊ��Ϊ 40 Ԫ");
		    }else if(age2 < 18 || age2 > 60){
		    	System.out.println("Ʊ��Ϊ 20 Ԫ");
		    }else if(age2 <= 0){
		    	System.out.println("������˼�������������");
		    }
		}else{
			System.out.println("������˼���·��������");
		}
	}
}