//����һ��char���͵�26��Ԫ�ص�����
//�ֱ����'A'-'Z'��ʹ��forѭ����������Ԫ�ز���ӡ����
//char��������'A'+1->'B'
public class ArrayExercise01{
	public static void main(String[] args){
		char a[] = new char[26];
		for(int i=0;i<a.length;i++){
			a[i] = (char)('A' + i);
		}
		System.out.println("====�����ڵ���====");
		//ѭ�����
		//
		for(int i=0;i<a.length;i++){
			System.out.println("��"+i+"����Ϊ"+a[i]);
		}
	}
}