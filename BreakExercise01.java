//1-100���ڵ��������
//������͵�һ�δ���20�ĵ�ǰ����
//
public class BreakExercise01{
	public static void main(String[] args){
		int sum = 0;//�ۼƺ�
		for(int i=1;i<=100;i++){
			sum = sum + i;
			if(sum > 20){
				System.out.println("������Ϊ��" + i);
				break;
			}
		}
	}
}