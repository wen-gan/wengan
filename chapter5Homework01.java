//某人有100000元，每经过一次路口需要交钱，规则为：
//当现金>50000时，每次交5%；
//当现金<=50000时，每次交1000.
//计算该人可以通过多少次路口(用while-break)
//
public class chapter5Homework01{
	public static void main(String[] args){
		double charge = 100000;
		int gate = 0;
		while(charge >= 0 ){
			if(charge > 50000){
				charge = charge - charge * 0.05;//还可以写成charge *= 0.95;
				gate++;
			}else if(charge <= 50000 && charge >= 1000){
				charge = charge - 1000;
				gate++;
			}else if(charge < 1000){//一定注意还有当钱小于1000的情况
				System.out.println("钱不够了");
				break;
			}
			
		}
		System.out.println("一共可以通过" + gate + "次，还剩 " + charge + "元");
	}
}