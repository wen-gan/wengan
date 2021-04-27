//float类型
//
public class FloatDetail{
	public static void main(String[] args){
		//float n1 = 1.1;//不能这样写，因为1.1默认为double型（8个字节），无法放入4个字节的float型
		float n1 = 1.1F;//这样写OK，因为1.1后面加了F，使得1.1变成了浮点型（4个字节）
		double n2 = 1.1;//这样是OK的
		double n3 = 1.1F;//这样写是可以的，因为1.1后面写了F使得1.1变成了浮点型（4个字节），而double是8个字节，可以放下
		double n4 = 5.12E-2;//0.0512
		double n5 = 5.12e2;//512.0
		System.out.println(n4);
		//浮点数陷阱 2.7和8.1 / 3的比较
		double n6 = 2.7;
		double n7 = 8.1 / 3.0 ;// 8.1 / 3 = 2.7
		System.out.println(n6);
		System.out.println(n7);
	}
}