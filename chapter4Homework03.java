//作业3
public class chapter4Homework03{
	public static void main(String[] args){
		//把字符串类型转换为double类型
		String str = "18.8";
		double d1 = Double.parseDouble(str);
		System.out.println(d1);
		//把其他类型转换为字符串类型
		char c1 = '文';
		String str2 = c1 + " ";
		System.out.println(str2);
	}
}