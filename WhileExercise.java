//��while��ӡ1-100֮�������ܱ�3��������
//
//
public class WhileExercise{
	public static void main(String[] args){
		// int i = 1 ;
		// int sum = 0;
		// while(i<=100){
		// 	if(i % 3 == 0){
		// 		System.out.println(i + "�ܱ�3����");
		// 		sum++;
		// 	}
		// 	i++;
		// }
		// System.out.println("�ܱ�3�����Ĺ��У�" + sum + "��");
		//��ӡ40-200֮�������ż��
		int i = 40;
		int sum = 0;
		while(i<=200 && i>=40){
		     if(i % 2 == 0){
			    System.out.println(i + "��ż��");
			    sum++;
		    }
		    i++;
		}
		System.out.println("��ż�����У�" + sum + "��");

	}
}