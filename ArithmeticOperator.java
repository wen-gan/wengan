/*算术运算符的使用*/

public class ArithmeticOperator{
	public static void main(String[] args){
		System.out.println(10 / 4);//在java中会得到2，因为10和4都是整型，所以结果也会是整型，就会变成2
		double d = 10 / 4;//在java中10/4只会得到2，赋值给double类型的d后会变成2.0
		System.out.println(d);//2.0
		//要得到2.5可以写成
		System.out.println(10.0 / 4);//得到2.5

		//取余=取模	
		//java中取模的本质：一个公式：a % b = a - a / b * b
		//-10 % 3 = -10 - (-10) / 3 * 3 =-1
		//10 % (-3) = 10 - 10 / (-3) * (-3) =1
		//-10 % (-3) = -10 - (-10) / (-3) * (-3) =-1
		System.out.println( 10 %  3);//得到1
		System.out.println(-10 %  3);//得到-1
		System.out.println( 10 % -3);//得到1
		System.out.println(-10 % -3);//得到-1
		//++的使用
		//
		int i = 10;
		i++;//自增 => i = i + 1 => 11
		++i;//自增 => i = i + 1 => 12
        System.out.println("i = " + i);
        //前++：++i先自增后赋值;
        //后++：i++先赋值后自增;
        int j = 8;
        //int k = ++j;//等价于j=j+1;k=j;
        int k = j++;//等价于k=j;j=j+1;
        System.out.println("j = " + j + "k = " + k);//k=8,j=9
	}
}