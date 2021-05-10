//创建一个Cale计算类
//在其中定义2个变量表示两个操作数
//定义四个方法实现求和、差、乘、商(若要求除数为0的话要提示)
//并创建两个对象，分别测试
public class chapter7Homework06{
	public static void main(String[] args){
		Cale calculator1 = new Cale(12,45);
		Cale calculator2 = new Cale(34,0);
		System.out.println("两个数的和为： " + calculator1.plus());
		System.out.println("两个数的差为： " + calculator1.reduce());
		System.out.println("两个数的积为： " + calculator2.mul());
		System.out.println("两个数的商为： " + calculator2.division());
	}
}

class Cale {
	double var1;
	double var2;
	public Cale(double var1,double var2){
		this.var1 = var1;
		this.var2 = var2;
	}
	public double plus(){
		return var1 + var2;
	}
	public double reduce(){
		return var1-var2;//Math.abs(var1-var2);
	}
	public double mul(){
		return var1*var2;
	}
	public double division(){
		if(var2!=0){
			return var1/var2;	
		}else{
			System.out.println("除数为0,计算有误");
		}
		return -1;
	}
}