//��֪��һ����������飬Ҫ�����һ��Ԫ��֮���������Ϊ����
//�磺{10,12,45,90}�ڲ���23����{10,12,23,45,90}
//
public class chapter6Homework04{
	public static void main(String[] args){
		int arr[] = {10,12,45,90};
		int addNum = 23;
		int index = -1;
		for(int i=0 ; i<arr.length ; i++){
			if(index <= arr[i]){
				index = i;
			    break;//�ҵ�λ�ú���˳�
			}
		}
		
		//�ж�index��ֵȷ�������λ��
		if(index == -1){//˵��û���ҵ�λ��
			index = arr.length;
		}

		//����һ���µ�����
		int arrNew[] = new int[arr.length+1];

		for(int i=0,j=0;i<arrNew.length;i++){
			if(i != index){//˵�����԰�arr��Ԫ�ؿ�����arrNew
				arrNew[i] = arr[j];
				j++;
			}else{//���λ�þ���Ҫ�������
				arrNew[i] = addNum;
			}
		}
		arr = arrNew;
		// int temp = 0;
		// for(int j=0 ; j<arrNew.length ; j++){
		// 	if(arrNew[j]>arrNew[j+1]){
		// 		temp = arrNew[j+1];
		// 		arrNew[j+1] = arrNew[j];
		// 		arrNew[j] = temp;
		// 	}
		// }
		System.out.println("====������====");
		for(int k=0 ; k<arr.length ; k++){
			System.out.print("arrNew=" + arr[k]+ " ");
		}
		
	}
}