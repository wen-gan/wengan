//随机生成10个整数(1-100)的范围
//并倒序打印以及求平均值、最大值和最大值的下标
//查找里面是否有8


public class chapter6Homework05{
	public static void main(String[] args){
		int arr[] = new int[10];
		for(int i=0; i<arr.length;i++){
			arr[i] = (int)(Math.random() * 100)+1;
		}
		System.out.println("====arr元素的情况=====");
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]+"\t");
		}
		System.out.println("====arr元素的情况(倒序)=====");
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
		System.out.println("平均值"+(sum/arr.length));
	}
}