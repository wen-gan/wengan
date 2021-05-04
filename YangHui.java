//打印杨辉三角
//1
//1 1
//1 2 1
//1 3 3 1
//1 4 6 4 1
//1 5 10 10 5 1
//1 6 15 20 15 6 1
//...
import java.util.Scanner;
public class YangHui{
	public static void main(String[] args){
		/*
		1. 第1行有1个元素，第n行有n个元素
		2. 每一行的首位的数都是1
		3. 从第3行开始，对于非第一个元素和最后一个元素的值
		   arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
		 */
		Scanner myscanner = new Scanner(System.in);
		//杨辉三角的层数
		System.out.println("请输入需要的杨辉三角的层数： ");
		int floor = myscanner.nextInt();
		//定义二维数组
		int yanghui[][] = new int[floor][];
		for(int i=0 ; i<yanghui.length ; i++){
			//给每个一维数组(行)开空间
			yanghui[i] = new int[i+1];
			//给每个一维数组(行)赋值
			for(int j=0 ; j<yanghui[i].length ; j++){
				if( j==0 || j==yanghui[i].length-1){
					yanghui[i][j] = 1;
				}else{
					yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];
				}
			}
		}
		//遍历输出杨辉三角
		for(int i=0; i<yanghui.length ; i++){
			for(int j=0; j<yanghui[i].length ; j++){
				System.out.print(yanghui[i][j] + " ");
			}
			//每一行打印完换行
			System.out.println();
		}
	}
}