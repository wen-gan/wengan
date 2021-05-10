//编写类AA 新方法：
//判断一个数是奇数odd还是偶数，返回boolean
//
//根据行、列、字符打印对应行数和列数的字符，比如：行4，列4，字符#，则打印相应的效果
public class MethodExercise01{
	public static void main(String[] args){
		int n = 10;
		AA a = new AA();
		if(a.choice(n)){
			System.out.println(n + "是一个偶数");
		}else{
			System.out.println(n + "是一个奇数");
		}
		
		a.print(4,4,'*');
	}
}

class AA {
	public boolean choice(int n) {
		boolean b = true;
		if(n%2 == 0){
			b = true;
		}else{
			b = false;
		}
		return b;
		//或者可以这样写更加简便
		//retrun n%2==0 ? true;false;
	}

	public void print(int row,int col,char c){
		for(int i=0; i<row ;i++){
			for(int j=0; j<col ;j++){
				System.out.print(c);
			}
			System.out.println();
		}
	}
}