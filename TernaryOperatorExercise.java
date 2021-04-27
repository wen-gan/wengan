//实现求出三个数中的最大值(使用三元算符)
//
public class TernaryOperatorExercise{
	public static void main(String[] args){
		int n1 = 90;
		int n2 = 67;
		int n3 = 45;
		int max = n1 > n2 ? n1:n2;
		max = max > n3 ? max:n3; 
		System.out.println("最大值为：" + max);//
		//使用一条语句实现
		//
		//int max = (n1>n2?n1:n2)>n3?(n1>n2?n1:n2):n3;
	}
}