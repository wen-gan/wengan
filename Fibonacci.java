//Fibonacci���еĴ�ӡ
//
public class Fibonacci{
	public static void main(String[] args){
		int n = 10;
		T fabe = new T();
		int fabe1 = fabe.f(n);
		System.out.println("n= "+n+"��Ӧ��쳲�������Ϊ��"+fabe1);
	}
}

class T{
	public int f(int n ){
		if( n==1 || n==2 ){
			return 1;
		}else if(n>2){
			return f(n-1) + f(n-2);
		}else{
			System.out.println("Ӧ���������0����");
			return -1;
		}
	}
}