//if-else练习
//
//
import java.util.Scanner;
public class IfExercise01{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("请输入第1个数：");
		double d1 = myscanner.nextDouble();
		System.out.println("请输入第2个数：");
		double d2 = myscanner.nextDouble();
		if(d1 > 10.0 && d2 < 20.0){
			System.out.println("两个数的和"+(d1+d2));
		}else{
			System.out.println("两个数的差"+(d1-d2));
		}

		//判断一个年份是否为闰年，闰年符合以下条件之一：
		//(1)年份能被4整除，但不能被100整除；(2)能被400整除
		System.out.println("请输入年份：");
		int year = myscanner.nextInt();
		if((year % 4 ==0 && year % 100 != 0) || year % 400 ==0){
			System.out.println(year + "是闰年");
		}else{
			System.out.println(year + "不是闰年");
		}
	}
}