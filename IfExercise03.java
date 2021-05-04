//出票系统
//4-10月为旺季：成人(18-60)60，儿童(<18)半价，老人(>60)20;
//淡季：成人40，其他20
//1.确定季节
//2.确定年龄
//3.确定票价
import java.util.Scanner;
public class IfExercise03{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("请输入月份： ");
		double month = myscanner.nextDouble();
		//开始判断语句
		if(month >= 4 && month <= 10){//旺季
			System.out.println("请输入年龄： ");
		    int age1 = myscanner.nextInt();
			if(age1 >= 18 && age1 <= 60){
				System.out.println("票价为 60 元");
			}else if(age1 < 18) {
				System.out.println("票价为 30 元");
			}else if(age1 > 60){
				System.out.println("票价为 20 元");
			}else if(age1 <= 0){
				System.out.println("不好意思，年龄输入错误");
			}
		}else if((month >= 1 && month < 4) || (month > 10 && month <= 12)){//淡季
			System.out.println("请输入年龄： ");
		    int age2 = myscanner.nextInt();
		    if(age2 >= 18 && age2 <= 60){
		    	System.out.println("票价为 40 元");
		    }else if(age2 < 18 || age2 > 60){
		    	System.out.println("票价为 20 元");
		    }else if(age2 <= 0){
		    	System.out.println("不好意思，年龄输入错误");
		    }
		}else{
			System.out.println("不好意思，月份输入错误");
		}
	}
}