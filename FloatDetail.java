//float����
//
public class FloatDetail{
	public static void main(String[] args){
		//float n1 = 1.1;//��������д����Ϊ1.1Ĭ��Ϊdouble�ͣ�8���ֽڣ����޷�����4���ֽڵ�float��
		float n1 = 1.1F;//����дOK����Ϊ1.1�������F��ʹ��1.1����˸����ͣ�4���ֽڣ�
		double n2 = 1.1;//������OK��
		double n3 = 1.1F;//����д�ǿ��Եģ���Ϊ1.1����д��Fʹ��1.1����˸����ͣ�4���ֽڣ�����double��8���ֽڣ����Է���
		double n4 = 5.12E-2;//0.0512
		double n5 = 5.12e2;//512.0
		System.out.println(n4);
		//���������� 2.7��8.1 / 3�ıȽ�
		double n6 = 2.7;
		double n7 = 8.1 / 3.0 ;// 8.1 / 3 = 2.7
		System.out.println(n6);
		System.out.println(n7);
	}
}