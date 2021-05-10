//Fibonacci数列的打印
//
public class Fibonacci{
	public static void main(String[] args){
		int n = 10;
		T fabe = new T();
		int fabe1 = fabe.f(n);
		System.out.println("n= "+n+"对应的斐波拉契数为："+fabe1);
	}
}

class T{
	public int f(int n ){
		if( n==1 || n==2 ){
			return 1;
		}else if(n>2){
			return f(n-1) + f(n-2);
		}else{
			System.out.println("应该输入大于0的数");
			return -1;
		}
	}
}