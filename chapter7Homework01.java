//定义类A01，定义方法max
//实现求某个double数组的最大值，并返回
public class chapter7Homework01{
	public static void main(String[] args){
		A01 a = new A01();
		double arr1[] = {};
		Double res = a.max(arr1);
		if(res != null){
			System.out.println("该数组的最大值为： " + res);
		}else{
			System.out.println("输入有误");
		}
		
	}
}

class A01 {
	public Double max(double[] arr){
		//先判断arr是否为空，再判断长度，因为如果为空就会报错
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