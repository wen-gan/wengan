//已知有一个升序的数组，要求插入一个元素之后该序列仍为升序
//如：{10,12,45,90}在插入23后变成{10,12,23,45,90}
//
public class chapter6Homework04{
	public static void main(String[] args){
		int arr[] = {10,12,45,90};
		int addNum = 23;
		int index = -1;
		for(int i=0 ; i<arr.length ; i++){
			if(index <= arr[i]){
				index = i;
			    break;//找到位置后就退出
			}
		}
		
		//判断index的值确定插入的位置
		if(index == -1){//说明没有找到位置
			index = arr.length;
		}

		//创建一个新的数组
		int arrNew[] = new int[arr.length+1];

		for(int i=0,j=0;i<arrNew.length;i++){
			if(i != index){//说明可以把arr的元素拷贝到arrNew
				arrNew[i] = arr[j];
				j++;
			}else{//这个位置就是要插入的数
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
		System.out.println("====新数组====");
		for(int k=0 ; k<arr.length ; k++){
			System.out.print("arrNew=" + arr[k]+ " ");
		}
		
	}
}