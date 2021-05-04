//实现有3次机会的登录验证
//如果用户名为丁真，密码为666时，提示登录成功
//否则提示还有几次机会
import java.util.Scanner;
public class BreakExercise02{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		int chance = 3;//登录一次少一次
		for(int i=1 ;i<=chance ;i++){
			System.out.println("请输入用户名：");
            String name = myscanner.next();
			System.out.println("请输入密码：");
			int key = myscanner.nextInt();
			if( "丁真".equals(name) && key == 666){//字符串内容的比较方法："".equals(name)
				System.out.println("登录成功");
				break;
			}
			//登录的机会减少一次
			System.out.println("用户名或密码错误，请重新输入，还有" + (chance-i) + "次机会");
		}
	}
}