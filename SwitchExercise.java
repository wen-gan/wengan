//��Сд���͵�charת���ɴ�д��char
//ֻת��a,b,c,d,e�����������Ϊothers
import java.util.Scanner;
public class SwitchExercise{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		// System.out.println("��������ĸ�� ");
		// char c1 = myscanner.next().charAt(0);
		// switch(c1){
		// 	case 'a' : 
		// 	System.out.println("A");
		// 	break;
		// 	case 'b' : 
		// 	System.out.println("B");
		// 	break;
		// 	case 'c' : 
		// 	System.out.println("C");
		// 	break;
		// 	case 'd' : 
		// 	System.out.println("D");
		// 	break;
		// 	case 'e' : 
		// 	System.out.println("E");
		// 	break;
		// 	case 'f' : 
		// 	System.out.println("F");
		// 	break;
		// 	default :
		// 	System.out.println("others");
		// 	break;
		// }
		//ѧ���ɼ�����60������ϸ񣬳ɼ�С��60��������ϸ�
		//����ɼ���60�������ϣ�����(int)�ɼ�/60=1��ʾ
		//����ɼ���60���£�����(int)�ɼ�/60=0��ʾ
		// System.out.println("������ɼ��� ");
		// double score = myscanner.nextDouble();
		// switch((int)(score / 60)){
		// 	case 0 : 
		// 	    System.out.println("�ɼ����ϸ�");
		// 	    break;
		// 	case 1 : 
		// 		System.out.println("�ɼ��ϸ�");
		// 		break;
		// 	// default :
		// 	// 	System.out.println("�ɼ���Ч");
		// 	// 	break;
		// }
		//ʹ�ô�͸
		//3,4,5������6,7,8�ļ���9,10,11�＾��12,1,2����
		System.out.println("�������·ݣ� ");
		int month = myscanner.nextInt();
		switch(month){
			case 3:
			case 4:
			case 5:
			    System.out.println("����");
			    break;
			case 6:
			case 7:
			case 8:
			    System.out.println("�ļ�");
			    break; 
			case 9:
			case 10:
			case 11:
			    System.out.println("�＾");
			    break;
			case 12:
			case 1:
			case 2:
			    System.out.println("����");
			    break;
			default:
			    System.out.println("��������");
			    break;
		}
	}
}