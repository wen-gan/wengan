//把小写类型的char转换成大写的char
//只转换a,b,c,d,e，其他的输出为others
import java.util.Scanner;
public class SwitchExercise{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		// System.out.println("请输入字母： ");
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
		//学生成绩大于60就输出合格，成绩小于60就输出不合格
		//如果成绩在60及其以上，就用(int)成绩/60=1表示
		//如果成绩在60以下，就用(int)成绩/60=0表示
		// System.out.println("请输入成绩： ");
		// double score = myscanner.nextDouble();
		// switch((int)(score / 60)){
		// 	case 0 : 
		// 	    System.out.println("成绩不合格");
		// 	    break;
		// 	case 1 : 
		// 		System.out.println("成绩合格");
		// 		break;
		// 	// default :
		// 	// 	System.out.println("成绩无效");
		// 	// 	break;
		// }
		//使用穿透
		//3,4,5春季，6,7,8夏季，9,10,11秋季，12,1,2冬季
		System.out.println("请输入月份： ");
		int month = myscanner.nextInt();
		switch(month){
			case 3:
			case 4:
			case 5:
			    System.out.println("春季");
			    break;
			case 6:
			case 7:
			case 8:
			    System.out.println("夏季");
			    break; 
			case 9:
			case 10:
			case 11:
			    System.out.println("秋季");
			    break;
			case 12:
			case 1:
			case 2:
			    System.out.println("冬季");
			    break;
			default:
			    System.out.println("输入有误");
			    break;
		}
	}
}