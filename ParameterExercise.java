//�ɱ��������
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
	//1. ������ showmore 
	//2. �β�(String , double...)
	//3. ����String
	public String showScore(String name, double... scores){
		double totalScore = 0;
		for(int i=0; i<scores.length; i++){
			totalScore += scores[i];
		}
		return name + "��" +scores.length + "�ɼ��ܷ�Ϊ= " + totalScore;
	}
}