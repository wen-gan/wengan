//������A01�����巽��max
//ʵ����ĳ��double��������ֵ��������
public class chapter7Homework01{
	public static void main(String[] args){
		A01 a = new A01();
		double arr1[] = {};
		Double res = a.max(arr1);
		if(res != null){
			System.out.println("����������ֵΪ�� " + res);
		}else{
			System.out.println("��������");
		}
		
	}
}

class A01 {
	public Double max(double[] arr){
		//���ж�arr�Ƿ�Ϊ�գ����жϳ��ȣ���Ϊ���Ϊ�վͻᱨ��
		if(arr != null && arr.length>0){
			double max = 0;
			for(int i=0; i<arr.length ; i++){
				if(max<arr[i]){
					max = arr[i];
				}
			}
			return max;	
		}else{
			return null;
		}

	}
}