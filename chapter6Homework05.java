//�������10������(1-100)�ķ�Χ
//�������ӡ�Լ���ƽ��ֵ�����ֵ�����ֵ���±�
//���������Ƿ���8


public class chapter6Homework05{
	public static void main(String[] args){
		int arr[] = new int[10];
		for(int i=0; i<arr.length;i++){
			arr[i] = (int)(Math.random() * 100)+1;
		}
		System.out.println("====arrԪ�ص����=====");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+"\t");
		}
		System.out.println("====arrԪ�ص����(����)=====");
		for(int i=arr.length-1;i>=0;i--){
			System.out.println(arr[i]+"\t");
		}

		double sum = arr[0];
		int max = arr[0];
		int maxIndex = 0;
		for(int i=1;i<arr.length;i++){
			if(max<arr[i]){
				max = arr[i];
				maxIndex = i;
			}
			sum += arr[i];
		}
		System.out.println("max="+max+"maxIndex"+maxIndex);
		System.out.println("ƽ��ֵ"+(sum/arr.length));
	}
}