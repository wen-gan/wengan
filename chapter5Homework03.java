//判断一年是否为闰年
//
import java.util.Scanner;
public class chapter5Homework03{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("请输入年份");
		int year = myscanner.nextInt();
		if((year%4==0 && year%100!=0) || year%400==0){
			System.out.println(year + "是闰年");
		}else{
			System.out.println(year + "不是闰年");
		}
	}
}