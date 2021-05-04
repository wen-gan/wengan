//用dowhile打印1-100
//用dowhile打印1-100的和
//用dowhile打印1-100之间能被5整除但是不能被3整除的数
public class DoWhileExercise{
	public static void main(String[] args){
		int i = 1;
		int sum = 0 ;
		do{
			// System.out.println(i);
			// sum = sum + i;
			// i++;
			if(i % 5 == 0 && i % 3 != 0){
				System.out.println(i + "可以被5整除但不能被3整除");
			}
			i++;
		}while(i<=100);
		// System.out.println("1-100的和为： " + sum);
	}
}