/*�����������ʹ��*/

public class ArithmeticOperator{
	public static void main(String[] args){
		System.out.println(10 / 4);//��java�л�õ�2����Ϊ10��4�������ͣ����Խ��Ҳ�������ͣ��ͻ���2
		double d = 10 / 4;//��java��10/4ֻ��õ�2����ֵ��double���͵�d�����2.0
		System.out.println(d);//2.0
		//Ҫ�õ�2.5����д��
		System.out.println(10.0 / 4);//�õ�2.5

		//ȡ��=ȡģ	
		//java��ȡģ�ı��ʣ�һ����ʽ��a % b = a - a / b * b
		//-10 % 3 = -10 - (-10) / 3 * 3 =-1
		//10 % (-3) = 10 - 10 / (-3) * (-3) =1
		//-10 % (-3) = -10 - (-10) / (-3) * (-3) =-1
		System.out.println( 10 %  3);//�õ�1
		System.out.println(-10 %  3);//�õ�-1
		System.out.println( 10 % -3);//�õ�1
		System.out.println(-10 % -3);//�õ�-1
		//++��ʹ��
		//
		int i = 10;
		i++;//���� => i = i + 1 => 11
		++i;//���� => i = i + 1 => 12
        System.out.println("i = " + i);
        //ǰ++��++i��������ֵ;
        //��++��i++�ȸ�ֵ������;
        int j = 8;
        //int k = ++j;//�ȼ���j=j+1;k=j;
        int k = j++;//�ȼ���k=j;j=j+1;
        System.out.println("j = " + j + "k = " + k);//k=8,j=9
	}
}