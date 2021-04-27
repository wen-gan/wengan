//自动数据类型转换细节
//
public class AutoconvertDetail{
	public static void main(String[] args){
	int n1 = 10;
	//float d1 = n1 + 1.1;//错误 n1 + 1.1的结果类型是 double(因为1.1默认为double类型，所以要按照精度最高的类型)
        double d1 = n1 + 1.1;//正确 n1 + 1.1的结果类型是 double
        float d2 = n1 + 1.1F;//正确 1.1F将1.1变成了float类型
        //（byte,short）和char之间不会相互转换
        byte b1 = 10;//-128~127
        //int n2 = 1;//1在int的范围内
        //byte b2 = n2;//错误，原因：如果是变量赋值则需要判断类型
        char n2 = b1;//错误，byte类型不能直接转换为char类型
        //
        //byte,short,char三者在计算时首先转换为int类型
        byte b2 = 1;
        short s1 = 1;
        short s2 = b2 + s1;//错误，b2 + s1 => int类型
        int s2 = b2 + s1;//正确

        //boolean类型不参与类型的自动转换
        boolean pass = true;
        int num = pass;//错误

        //自动提升原则
        byte b2 = 1;
        short n3 = 100;
        int s3 = 5;
        double s4 = 'gan';
        double num100 = b2 + n3 + s3 + s4;//其中精度最大的是double，那最后会编程double型

	}

}