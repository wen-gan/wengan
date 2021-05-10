//定义Music类，里面有音乐名name、音乐时长times属性
//并且有播放play功能和返回本身属性信息的功能方法getInfo
public class chapter7Homework09{
	public static void main(String[] args){
		Music music = new Music("月亮之上",3.5);
		System.out.println("播放"+music.getInfo());
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
		return "音乐"+this.name+"播放时间为"+this.times;
	}
	public void play(){
		System.out.println("播放" + this.name + "音乐");
		System.out.println("时长" + this.times + "min");
	}
}