//���Сд��a-z�Լ���д��Z-A
//
//
public class chapter5Homework07{
	public static void main(String[] args){
		//���a-z
		int count1 = 0;
		for(char w1='a'; w1<='z';w1++){//�ַ��ǿ��ԱȽϴ�С��
			System.out.print(w1 + " ");
			count1++;
			if(count1%5 == 0){
				System.out.print("\n");
			}
		}
		System.out.print("\n");
		//���Z-A
		int count2 = 0;
		for(char w2='Z'; w2>='A';w2--){//�ַ��ǿ��ԱȽϴ�С��
			System.out.print(w2 + " ");
			count2++;
			if(count2%5 == 0){
				System.out.print("\n");
			}
		}
	}
}