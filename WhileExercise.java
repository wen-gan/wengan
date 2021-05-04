//用while打印1-100之间所有能被3整除的数
//
//
public class WhileExercise{
	public static void main(String[] args){
		// int i = 1 ;
		// int sum = 0;
		// while(i<=100){
		// 	if(i % 3 == 0){
		// 		System.out.println(i + "能被3整除");
		// 		sum++;
		// 	}
		// 	i++;
		// }
		// System.out.println("能被3整除的共有：" + sum + "个");
		//打印40-200之间的所有偶数
		int i = 40;
		int sum = 0;
		while(i<=200 && i>=40){
		     if(i % 2 == 0){
			    System.out.println(i + "是偶数");
			    sum++;
		    }
		    i++;
		}
		System.out.println("是偶数的有：" + sum + "个");

	}
}