//if语句的使用
import java.util.Scanner;
public class IfExercise02{
	public static void main(String[] args){
	Scanner myscanner = new Scanner(System.in);
	System.out.println("信用积分值(1-100)： ");
	double d1 = myscanner.nextDouble();
	if (d1 >= 1 && d1 <= 100){
		if(d1 == 100){
			System.out.println("信用极好");
		}else if (d1 > 80 && d1 <= 99) {
			System.out.println("信用优秀");
		}else if (d1 > 60 && d1 <= 80) {
			System.out.println("信用一般");
		}else {
			System.out.println("信用不及格");
		}
	}else{
		System.out.println("不满足条件，请输入1-100的信用积分");
	}
	}
}