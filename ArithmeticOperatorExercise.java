//��59�����ܺ�ʣ�������
//
public class ArithmeticOperatorExercise{
	public static void main(String[] args){
		//һ��Ϊ7��
		int i1 = 59;
		int i2 = 7;
		int w = i1 / i2;
		int d = i1 % i2;
		System.out.println("����żٻ���59�죬��Ϊ" + w + "��" + d + "��");
		//��ʽ�¶�ת�����¶ȣ���ʽΪ5/9*(�����¶�-100)�����234.5��ʽ�¶ȶ�Ӧ�������¶�
		double t1 = 234.5;
		//��Ҫʹ��5.0����ʹ�ü�����Ϊdouble���ͣ����ֱ��5/9Ĭ�ϻ�õ�����int���͵���
		double t2 = 5.0 / 9 * (t1 - 100);
		System.out.println("234.5��ʽ�¶ȶ�Ӧ�������¶�Ϊ" + t2);
	}
}
	