//ʵ����3�λ���ĵ�¼��֤
//����û���Ϊ���棬����Ϊ666ʱ����ʾ��¼�ɹ�
//������ʾ���м��λ���
import java.util.Scanner;
public class BreakExercise02{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		int chance = 3;//��¼һ����һ��
		for(int i=1 ;i<=chance ;i++){
			System.out.println("�������û�����");
            String name = myscanner.next();
			System.out.println("���������룺");
			int key = myscanner.nextInt();
			if( "����".equals(name) && key == 666){//�ַ������ݵıȽϷ�����"".equals(name)
				System.out.println("��¼�ɹ�");
				break;
			}
			//��¼�Ļ������һ��
			System.out.println("�û���������������������룬����" + (chance-i) + "�λ���");
		}
	}
}