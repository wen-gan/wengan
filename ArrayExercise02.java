//求出数组int[]的最大值{4,-1,9,10,23},并得到对应的下标
//
public class ArrayExercise02{
	public static void main(String[] args){
		int chars[] = {4,-1,45,10,2};
		//假定第一个数为最大值
		int max = chars[0];
		int count = 0;
		for(int i=0;i<chars.length;i++){
			if(chars[i] > max){
				max = chars[i];
				count = i;
			}
		}
		System.out.println("该数组的最大值为： " + max + "，其下标为： " + count);
	}
}