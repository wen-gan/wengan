//���3�����ͳ�ƣ�ÿ������5��ͬѧ��
//����������ƽ���ֺ����а��ƽ����[ѧ���ĳɼ��Ӽ��̼���]
import java.util.Scanner;
public class MulForExercise{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		double sum = 0;
		double sumall = 0;
		int s = 0;
		for(int i = 1; i <= 3; i++){//����3���༶����ѭ��3��
			for(int j = 1; j <= 5; j++){//һ���༶����5��ѧ������ѭ��5��
				System.out.println("�������"+i+"���༶�ĵ�"+j+"��ѧ���ɼ��� ");
				double grade = myscanner.nextDouble();
				sum = sum + grade;//�ռ��ð༶���ܷ�
				if(grade >= 60){//�ռ����������
					s++;
				}
			}
			sumall = sumall + sum;//�ռ������༶���ܷ�
			double average = sum / 5;//�õ������༶��ƽ����
			System.out.println("��"+i+"���༶��ƽ���ɼ�Ϊ�� " + average);
			sum = 0;//��sum���㣬���ڼ�����һ���༶�ķ���
		}
		double averageall = sumall / 15;//�õ������꼶��ƽ����
		System.out.println("���꼶��ƽ���ɼ�Ϊ�� " + averageall);
		System.out.println("���꼶�У� " + s + "������");
		System.out.println("���꼶�У� " + (15-s) + "��������");
	}
}