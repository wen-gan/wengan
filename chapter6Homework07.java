//��ҵ7


public class chapter6Homework07{
	public static void main(String[] args){
		int arr[] = {24,69,80,57,13,-1,145,-56,2};
		int temp = 0;
		for(int i=0;i<arr.length-1;i++){
			for(int j=0 ; j<(arr.length-1-i) ; j++){
				//���ǰ��������ں�������ͽ���λ��
				if(arr[j] > arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			System.out.println("\n====��" + (i+1) + "��====");
			for(int j=0;j<arr.length;j++){
				System.out.print(arr[j] + "\t");
			}	
		}
	}
}