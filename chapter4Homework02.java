//作业2
public class chapter4Homework02{
	public static void main(String[] args){
	int i = 66;
	//++i的优先级更高，所以会先执行++i,
	//前++代表先自增后赋值，所以(1)i=i+1=67(2)67+i(此时的i=67)(3)结果为134
	System.out.println(++i+i);//134
	}
}