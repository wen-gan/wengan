//��1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+100)�Ľ��
//��������Ӧ��������ѭ��������ѭ����Ƕ�ף����ѭ��Ϊ�������ţ��ڲ�ѭ��Ϊ1-100
//
public class chapter5Homework09{
	public static void main(String[] args){
		int sum = 0;
		//i ���Ա�ʾ�ǵڼ��ͬʱҲ�ǵ�ǰ������һ����
		for(int i = 1;i <= 100; i++){
			for(int j = 1;j <= i; j++){//�ڲ��iѭ��
				sum = sum + j;
			}
		}
		System.out.println("1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+100)�Ľ��Ϊ�� " + sum);
	}
}