//ʵ������������е����ֵ(ʹ����Ԫ���)
//
public class TernaryOperatorExercise{
	public static void main(String[] args){
		int n1 = 90;
		int n2 = 67;
		int n3 = 45;
		int max = n1 > n2 ? n1:n2;
		max = max > n3 ? max:n3; 
		System.out.println("���ֵΪ��" + max);//
		//ʹ��һ�����ʵ��
		//
		//int max = (n1>n2?n1:n2)>n3?(n1>n2?n1:n2):n3;
	}
}