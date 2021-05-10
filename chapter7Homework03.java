//编写类Book，定义方法updatePrice，实现更改某本书的价格
//如果价格>150，则更改为150
//如果价格>100，则更改为100
//否则不变
public class chapter7Homework03{
	public static void main(String[] args){
		Book02 book = new Book02("神雕侠侣",160);
		book.info();
		book.updatePrice();//更新价格
		book.info();
	}
}

// class Book01 {
// 	public int updatePrice (int a){
// 		if(a>=150){
// 			return 150;
// 		}else if(a>=100 && a<150){
// 			return 100;
// 		}else if(a<100){
// 			return a;
// 		}
// 		return -1;
// 	}
// }

class Book02 {
	String name;
	double price;
	public Book02(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public void updatePrice(){
		if(this.price > 150){
			this.price = 150;
		}else if(this.price > 100){
			this.price = 100;
		}
	}
	//显示书籍的情况
	public void info(){
		System.out.println("书名= "+this.name+ " " + "价格= " + this.price);
	}
}