//�����ж�һ����λ���Ƿ�Ϊˮ�ɻ���
//ˮ�ɻ�����ÿһ����λ�ϵ����ֵ������͵��ڸ�����
//n1=num/100=��λ
//n2=(num-n1*100)/10=ʮλ
//n3=(num-n1*100-n2*10)=��λ
import java.util.Scanner;
public class chapter5Homework04{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("������һ����λ���� ");
		int num = myscanner.nextInt();
		int n1=num/100;
		int n2=(num-n1*100)/10;//���߿���num%100/10
		int n3=num-n1*100-n2*10;//���߿���num%10
		System.out.println(num + "�İ�λ��Ϊ " + n1 +",ʮλ��Ϊ " + n2 + ",��λ��Ϊ " + n3);
		if((n1*n1*n1+n2*n2*n2+n3*n3*n3) == num){
			System.out.println(num + "��ˮ�ɻ���");
		}else{
			System.out.println(num + "����ˮ�ɻ���");
		}
	}
}