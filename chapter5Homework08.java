//求出1-1/2+1/3-1/4......1/100的和
//分析可以得出一共100个数，分子为1，分母从1-100
//还有当分母为奇数时，前面是+；当分母为偶数时，前面是-
//要把公式的分子写成1.0才能得到精确的值
public class chapter5Homework08{
	public static void main(String[] args){
		double sum = 0;
		for(int i = 1;i <= 100;i++){
			//判断是奇数还是偶数
			if(i%2!=0){//分母为奇数
				sum += (1.0/i);
			}else{//分母为偶数
				sum -= (1.0/i);
			}
		}
		System.out.println("1-1/2+1/3-1/4......1/100的和为： " + sum);
	}
}