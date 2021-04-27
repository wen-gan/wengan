//作业1
public class chapter4Homework01{
	public static void main(String[] args){
		//10/3=>10和3都是整型，所以结果也为整型=3
		System.out.println(10/3);
		//10/5=>10和5都是整型，所以结果也为整型=2
		System.out.println(10/5);
		//10%2 => 10 - 10 / 2 * 2 = 0
		System.out.println(10%2);
		//-10.5%3 => -10.5 - (-10.5) / 3 * 3 = -1.5
		//当%左边的数为小数的时候公式变为：a-(int)a/b*b(有一个类型强转的过程)
		//有小数运算时，得到的结果是近似值
		System.out.println(-10.5%3);
	}
}