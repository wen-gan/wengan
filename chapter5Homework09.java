//求1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+100)的结果
//初步分析应该有两个循环，即有循环的嵌套，外层循环为各个括号，内层循环为1-100
//
public class chapter5Homework09{
	public static void main(String[] args){
		int sum = 0;
		//i 可以表示是第几项，同时也是当前项的最后一个数
		for(int i = 1;i <= 100; i++){
			for(int j = 1;j <= i; j++){//内层对i循环
				sum = sum + j;
			}
		}
		System.out.println("1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+100)的结果为： " + sum);
	}
}