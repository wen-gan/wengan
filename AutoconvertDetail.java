//�Զ���������ת��ϸ��
//
public class AutoconvertDetail{
	public static void main(String[] args){
	int n1 = 10;
	//float d1 = n1 + 1.1;//���� n1 + 1.1�Ľ�������� double(��Ϊ1.1Ĭ��Ϊdouble���ͣ�����Ҫ���վ�����ߵ�����)
        double d1 = n1 + 1.1;//��ȷ n1 + 1.1�Ľ�������� double
        float d2 = n1 + 1.1F;//��ȷ 1.1F��1.1�����float����
        //��byte,short����char֮�䲻���໥ת��
        byte b1 = 10;//-128~127
        //int n2 = 1;//1��int�ķ�Χ��
        //byte b2 = n2;//����ԭ������Ǳ�����ֵ����Ҫ�ж�����
        char n2 = b1;//����byte���Ͳ���ֱ��ת��Ϊchar����
        //
        //byte,short,char�����ڼ���ʱ����ת��Ϊint����
        byte b2 = 1;
        short s1 = 1;
        short s2 = b2 + s1;//����b2 + s1 => int����
        int s2 = b2 + s1;//��ȷ

        //boolean���Ͳ��������͵��Զ�ת��
        boolean pass = true;
        int num = pass;//����

        //�Զ�����ԭ��
        byte b2 = 1;
        short n3 = 100;
        int s3 = 5;
        double s4 = 'gan';
        double num100 = b2 + n3 + s3 + s4;//���о���������double����������double��

	}

}