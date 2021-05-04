//��ӡ�������
//1
//1 1
//1 2 1
//1 3 3 1
//1 4 6 4 1
//1 5 10 10 5 1
//1 6 15 20 15 6 1
//...
import java.util.Scanner;
public class YangHui{
	public static void main(String[] args){
		/*
		1. ��1����1��Ԫ�أ���n����n��Ԫ��
		2. ÿһ�е���λ��������1
		3. �ӵ�3�п�ʼ�����ڷǵ�һ��Ԫ�غ����һ��Ԫ�ص�ֵ
		   arr[i][j] = arr[i-1][j] + arr[i-1][j-1]
		 */
		Scanner myscanner = new Scanner(System.in);
		//������ǵĲ���
		System.out.println("��������Ҫ��������ǵĲ����� ");
		int floor = myscanner.nextInt();
		//�����ά����
		int yanghui[][] = new int[floor][];
		for(int i=0 ; i<yanghui.length ; i++){
			//��ÿ��һά����(��)���ռ�
			yanghui[i] = new int[i+1];
			//��ÿ��һά����(��)��ֵ
			for(int j=0 ; j<yanghui[i].length ; j++){
				if( j==0 || j==yanghui[i].length-1){
					yanghui[i][j] = 1;
				}else{
					yanghui[i][j] = yanghui[i-1][j] + yanghui[i-1][j-1];
				}
			}
		}
		//��������������
		for(int i=0; i<yanghui.length ; i++){
			for(int j=0; j<yanghui[i].length ; j++){
				System.out.print(yanghui[i][j] + " ");
			}
			//ÿһ�д�ӡ�껻��
			System.out.println();
		}
	}
}