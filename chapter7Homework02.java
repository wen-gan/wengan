//��д��A02�����巽��find
//ʵ�ֲ���ĳ�ַ��������е�Ԫ�ز���
//����������������Ҳ����ͷ���-1
public class chapter7Homework02{
	public static void main(String[] args){
		A02 a = new A02();
		String strs[] = {"jack", "tom", "marry", "milan"};
		System.out.println("����ֵΪ" + a.find(strs,"marry"));
	}
}

class A02 {
	public int find(String s[],String c){
		//�����ַ������飬����ҵ��ͷ�������
		for(int i=0; i<s.length ; i++){
			if(c.equals(s[i])){
				return i;
			}
		}
		return -1;
	}
}