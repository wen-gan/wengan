//编写类A03
//实现数组的复制功能copyArr
//输入旧数组，返回一个新数组，元素和旧数组一样
public class chapter7Homework04{
	public static void main(String[] args){
		A03 arr = new A03();
		double arr03[] = {1,2,3,4};
		double arr04[] = arr.copyArr(arr03);
		for(int i=0;i<arr04.length;i++){
			System.out.println(arr04[i] + " ");
		}
		
	}
}

class A03 {

	public double[] copyArr (double[] arr01){
		//遍历数组
		double[] arr02 = new double[arr01.length];
		for(int i=0; i<arr01.length ; i++){
				arr02[i] = arr01[i];
			}
		return arr02;
	}
}