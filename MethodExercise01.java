//��д��AA �·�����
//�ж�һ����������odd����ż��������boolean
//
//�����С��С��ַ���ӡ��Ӧ�������������ַ������磺��4����4���ַ�#�����ӡ��Ӧ��Ч��
public class MethodExercise01{
	public static void main(String[] args){
		int n = 10;
		AA a = new AA();
		if(a.choice(n)){
			System.out.println(n + "��һ��ż��");
		}else{
			System.out.println(n + "��һ������");
		}
		
		a.print(4,4,'*');
	}
}

class AA {
	public boolean choice(int n) {
		boolean b = true;
		if(n%2 == 0){
			b = true;
		}else{
			b = false;
		}
		return b;
		//���߿�������д���Ӽ��
		//retrun n%2==0 ? true;false;
	}

	public void print(int row,int col,char c){
		for(int i=0; i<row ;i++){
			for(int j=0; j<col ;j++){
				System.out.print(c);
			}
			System.out.println();
		}
	}
}