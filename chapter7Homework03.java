//��д��Book�����巽��updatePrice��ʵ�ָ���ĳ����ļ۸�
//����۸�>150�������Ϊ150
//����۸�>100�������Ϊ100
//���򲻱�
public class chapter7Homework03{
	public static void main(String[] args){
		Book02 book = new Book02("�������",160);
		book.info();
		book.updatePrice();//���¼۸�
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
	//��ʾ�鼮�����
	public void info(){
		System.out.println("����= "+this.name+ " " + "�۸�= " + this.price);
	}
}