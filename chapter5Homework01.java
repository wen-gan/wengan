//ĳ����100000Ԫ��ÿ����һ��·����Ҫ��Ǯ������Ϊ��
//���ֽ�>50000ʱ��ÿ�ν�5%��
//���ֽ�<=50000ʱ��ÿ�ν�1000.
//������˿���ͨ�����ٴ�·��(��while-break)
//
public class chapter5Homework01{
	public static void main(String[] args){
		double charge = 100000;
		int gate = 0;
		while(charge >= 0 ){
			if(charge > 50000){
				charge = charge - charge * 0.05;//������д��charge *= 0.95;
				gate++;
			}else if(charge <= 50000 && charge >= 1000){
				charge = charge - 1000;
				gate++;
			}else if(charge < 1000){//һ��ע�⻹�е�ǮС��1000�����
				System.out.println("Ǯ������");
				break;
			}
			
		}
		System.out.println("һ������ͨ��" + gate + "�Σ���ʣ " + charge + "Ԫ");
	}
}