//实现判断一个整数属于哪个范围
//大于0，小于0，等于0
import java.util.Scanner;
public class chapter5Homework02{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("请输入整数： ");
		int i = myscanner.nextInt();
		if(i>0){
			System.out.println("该数大于0");
		}else if(i < 0){
			System.out.println("该数小于0");
		}else{
			System.out.println("该数等于0");
		}
	}
}