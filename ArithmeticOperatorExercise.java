//把59天变成周和剩余的天数
//
public class ArithmeticOperatorExercise{
	public static void main(String[] args){
		//一周为7天
		int i1 = 59;
		int i2 = 7;
		int w = i1 / i2;
		int d = i1 % i2;
		System.out.println("距离放假还有59天，即为" + w + "周" + d + "天");
		//华式温度转摄氏温度，公式为5/9*(华氏温度-100)，求出234.5华式温度对应的摄氏温度
		double t1 = 234.5;
		//需要使用5.0才能使得计算结果为double类型，如果直接5/9默认会得到的是int类型的数
		double t2 = 5.0 / 9 * (t1 - 100);
		System.out.println("234.5华式温度对应的摄氏温度为" + t2);
	}
}
	