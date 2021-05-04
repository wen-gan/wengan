//打印1-100之间的所有是9的倍数的整数
//并且统计个数以及总和
//
public class ForExercise{
	public static void main(String[] args){
		int count = 0;
		int sum = 0;
		int start = 5;
		int end = 200;
		int i1 = 5;
		for(int i = start; i <= end; i++){
			if(i % i1 == 0){
				System.out.println(i1 +"的倍数(整数)有： " + i);
				count += 1;
				sum = sum + i;
			}
		}
		System.out.println(i1 +"的倍数(整数)有： " + count + "个");
		System.out.println(i1 +"的倍数(整数)之和为： " + sum);
	}
}