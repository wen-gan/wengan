//��dowhile��ӡ1-100
//��dowhile��ӡ1-100�ĺ�
//��dowhile��ӡ1-100֮���ܱ�5�������ǲ��ܱ�3��������
public class DoWhileExercise{
	public static void main(String[] args){
		int i = 1;
		int sum = 0 ;
		do{
			// System.out.println(i);
			// sum = sum + i;
			// i++;
			if(i % 5 == 0 && i % 3 != 0){
				System.out.println(i + "���Ա�5���������ܱ�3����");
			}
			i++;
		}while(i<=100);
		// System.out.println("1-100�ĺ�Ϊ�� " + sum);
	}
}