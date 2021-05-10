//可变参数类型
//
//
public class ParameterExercise{
	public static void main(String[] args){
		Method hm = new Method();
		System.out.println(hm.showScore("milan",90.1,80.0));
		System.out.println(hm.showScore("terry",90.1,80.0,100));
	}
}

class Method{
	//1. 方法名 showmore 
	//2. 形参(String , double...)
	//3. 返回String
	public String showScore(String name, double... scores){
		double totalScore = 0;
		for(int i=0; i<scores.length; i++){
			totalScore += scores[i];
		}
		return name + "有" +scores.length + "成绩总分为= " + totalScore;
	}
}