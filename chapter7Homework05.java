//定义一个圆类Cricle
//其属性为半径
//提供显示圆周长功能的方法
//提供显示圆面积的方法
public class chapter7Homework05{
	public static void main(String[] args){
		Circle circle = new Circle(3.0);
		System.out.println("该圆的周长为：" + circle.Perimeter());
		System.out.println("该圆的面积为：" + circle.area());
	}
}

class Circle {
	double r;
	public Circle(double r){
		this.r = r;
	}
	public double Perimeter(){
		return 2*Math.PI*this.r;
	}
	public double area(){
		return Math.PI*this.r*this.r;
	}
}