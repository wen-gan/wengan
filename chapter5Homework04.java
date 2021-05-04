//程序判断一个三位数是否为水仙花数
//水仙花数即每一个数位上的数字的立方和等于该数字
//n1=num/100=百位
//n2=(num-n1*100)/10=十位
//n3=(num-n1*100-n2*10)=个位
import java.util.Scanner;
public class chapter5Homework04{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("请输入一个三位数： ");
		int num = myscanner.nextInt();
		int n1=num/100;
		int n2=(num-n1*100)/10;//或者可以num%100/10
		int n3=num-n1*100-n2*10;//或者可以num%10
		System.out.println(num + "的百位数为 " + n1 +",十位数为 " + n2 + ",个位数为 " + n3);
		if((n1*n1*n1+n2*n2*n2+n3*n3*n3) == num){
			System.out.println(num + "是水仙花数");
		}else{
			System.out.println(num + "不是水仙花数");
		}
	}
}