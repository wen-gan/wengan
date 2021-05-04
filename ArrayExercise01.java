//创建一个char类型的26个元素的数组
//分别放置'A'-'Z'，使用for循环访问所有元素并打印出来
//char类型数据'A'+1->'B'
public class ArrayExercise01{
	public static void main(String[] args){
		char a[] = new char[26];
		for(int i=0;i<a.length;i++){
			a[i] = (char)('A' + i);
		}
		System.out.println("====数组内的数====");
		//循环输出
		//
		for(int i=0;i<a.length;i++){
			System.out.println("第"+i+"个数为"+a[i]);
		}
	}
}