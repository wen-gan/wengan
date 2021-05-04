//程序实现空心金字塔
//
public class Stars{
	public static void main(String[] args){
		//每行的空格数：
		//1 5-1=4
		//2 5-2=3
		//3 5-3=2
		//4 5-4=1
		//5 5-5=0
		int floor = 30;//金字塔的层数
		//总共有多少层就循环多少次
		for(int i=1 ;i<=floor; i++){
			//此循环用于打空格
			for(int k=1;k<=floor-i;k++){
			    System.out.print(" ");
		    }
		    //此循环用于打星星
		    //星星的个数与是第几行有关，公式为2*i-1
		    //比如第一行2*1-1=1，第二行2*2-1=3
			for(int j = 1;j <= 2*i -1; j++){
				//当前行的第一个位置和最后一个位置需要打*，最后一层全部输出
				if(j == 1 || j == 2*i-1 || i == floor){
					System.out.print("*");
				}else{//其他情况输出空格
					System.out.print(" ");
				}
			}
			//每一行的星星打完后需要换行到下一行
			System.out.print("\n");
		}
	}
}