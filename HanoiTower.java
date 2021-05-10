//汉诺塔递归

public class HanoiTower{
	public static void main(String[] args){
		Tower tower = new Tower();
		tower.move(5,'A','B','C');
	}
}

class Tower{
	//方法
	//num 表示要移动的个数，a,b,c分别表示A塔，B塔，C塔
	public void move(int num, char a, char b,char c){
		//如果只有一个盘 num = 1
		if(num == 1){
			System.out.println(a + "->" + c);
		} else{
			//如果有多个盘，可以看成两个盘即最下面的和上面的所有盘
			//1. 先移动所有的盘到b，借助c
			move(num-1,a,c,b);
			//2. 把最下面盘移动到c
			System.out.println(a+"->"+c);
			//3. 再把b塔的所有盘移动到c，但中间要借助到a
			move(num-1,b,a,c);
		}
	}
}