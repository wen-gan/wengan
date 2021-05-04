//输出小写的a-z以及大写的Z-A
//
//
public class chapter5Homework07{
	public static void main(String[] args){
		//输出a-z
		int count1 = 0;
		for(char w1='a'; w1<='z';w1++){//字符是可以比较大小的
			System.out.print(w1 + " ");
			count1++;
			if(count1%5 == 0){
				System.out.print("\n");
			}
		}
		System.out.print("\n");
		//输出Z-A
		int count2 = 0;
		for(char w2='Z'; w2>='A';w2--){//字符是可以比较大小的
			System.out.print(w2 + " ");
			count2++;
			if(count2%5 == 0){
				System.out.print("\n");
			}
		}
	}
}