//��ӡ1-100֮���������9�ı���������
//����ͳ�Ƹ����Լ��ܺ�
//
public class ForExercise{
	public static void main(String[] args){
		int count = 0;
		int sum = 0;
		int start = 5;
		int end = 200;
		int i1 = 5;
		for(int i = start; i <= end; i++){
			if(i % i1 == 0){
				System.out.println(i1 +"�ı���(����)�У� " + i);
				count += 1;
				sum = sum + i;
			}
		}
		System.out.println(i1 +"�ı���(����)�У� " + count + "��");
		System.out.println(i1 +"�ı���(����)֮��Ϊ�� " + sum);
	}
}