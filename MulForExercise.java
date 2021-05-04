//完成3个班的统计，每个班有5名同学，
//求出各个班的平均分和所有班的平均分[学生的成绩从键盘键入]
import java.util.Scanner;
public class MulForExercise{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		double sum = 0;
		double sumall = 0;
		int s = 0;
		for(int i = 1; i <= 3; i++){//共有3个班级，则循环3次
			for(int j = 1; j <= 5; j++){//一个班级里有5个学生，则循环5次
				System.out.println("请输入第"+i+"个班级的第"+j+"个学生成绩： ");
				double grade = myscanner.nextDouble();
				sum = sum + grade;//收集该班级的总分
				if(grade >= 60){//收集及格的人数
					s++;
				}
			}
			sumall = sumall + sum;//收集各个班级的总分
			double average = sum / 5;//得到各个班级的平均分
			System.out.println("第"+i+"个班级的平均成绩为： " + average);
			sum = 0;//将sum清零，便于计算下一个班级的分数
		}
		double averageall = sumall / 15;//得到整个年级的平均分
		System.out.println("该年级的平均成绩为： " + averageall);
		System.out.println("该年级有： " + s + "个及格");
		System.out.println("该年级有： " + (15-s) + "个不及格");
	}
}