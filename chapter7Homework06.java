//����һ��Cale������
//�����ж���2��������ʾ����������
//�����ĸ�����ʵ����͡���ˡ���(��Ҫ�����Ϊ0�Ļ�Ҫ��ʾ)
//�������������󣬷ֱ����
public class chapter7Homework06{
	public static void main(String[] args){
		Cale calculator1 = new Cale(12,45);
		Cale calculator2 = new Cale(34,0);
		System.out.println("�������ĺ�Ϊ�� " + calculator1.plus());
		System.out.println("�������Ĳ�Ϊ�� " + calculator1.reduce());
		System.out.println("�������Ļ�Ϊ�� " + calculator2.mul());
		System.out.println("����������Ϊ�� " + calculator2.division());
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
			System.out.println("����Ϊ0,��������");
		}
		return -1;
	}
}