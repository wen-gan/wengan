//����Music�࣬������������name������ʱ��times����
//�����в���play���ܺͷ��ر���������Ϣ�Ĺ��ܷ���getInfo
public class chapter7Homework09{
	public static void main(String[] args){
		Music music = new Music("����֮��",3.5);
		System.out.println("����"+music.getInfo());
		music.play();
	}
}

class Music {
	String name;
	double times;
	public Music(String name, double times){
		this.name = name;
		this.times = times;
	}
	public String getInfo(){
		return "����"+this.name+"����ʱ��Ϊ"+this.times;
	}
	public void play(){
		System.out.println("����" + this.name + "����");
		System.out.println("ʱ��" + this.times + "min");
	}
}