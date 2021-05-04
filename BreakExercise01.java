//1-100以内的数字求和
//求出当和第一次大于20的当前数字
//
public class BreakExercise01{
	public static void main(String[] args){
		int sum = 0;//累计和
		for(int i=1;i<=100;i++){
			sum = sum + i;
			if(sum > 20){
				System.out.println("该数字为：" + i);
				break;
			}
		}
	}
}