//�������int[]�����ֵ{4,-1,9,10,23},���õ���Ӧ���±�
//
public class ArrayExercise02{
	public static void main(String[] args){
		int chars[] = {4,-1,45,10,2};
		//�ٶ���һ����Ϊ���ֵ
		int max = chars[0];
		int count = 0;
		for(int i=0;i<chars.length;i++){
			if(chars[i] > max){
				max = chars[i];
				count = i;
			}
		}
		System.out.println("����������ֵΪ�� " + max + "�����±�Ϊ�� " + count);
	}
}