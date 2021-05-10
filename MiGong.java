//迷宫问题
//
public class MiGong{
	public static void main(String[] args){
		//	思路
		//1. 先创建迷宫，用二维数组表示： int[][] map = new int[8][9]
		//2. 再规定 map 数组的元素值：0 表示可以走; 1 表示障碍物
		
		int[][] map = new int[8][7];
		//3. 将最上面的一行和最下面的一行全部设置为1
		for(int i = 0; i<7 ; i++){
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//4. 将最右边的一列和最左边的一类全部设置为1
		for(int i=0;i<8;i++){
			map[i][0]=1;
			map[i][6]=1;
		}
		//障碍物的设置
		map[3][1] = 1;
		map[3][2] = 1;
		map[2][2] = 1;
		//输出当前地图
		System.out.println("====当前地图情况====");
		for(int i=0; i<map.length ; i++){
			for(int j=0 ; j<map[i].length;j++){
				System.out.print(map[i][j] + " ");//输出一行
			}
			System.out.println();
		}

		//使用findWay给老鼠找路
		T t1 = new T();
		t1.findWay(map,1,1);

		System.out.println("====找路的情况如下====");
		for(int i=0; i<map.length ; i++){
			for(int j=0 ; j<map[i].length;j++){
				System.out.print(map[i][j] + " ");//输出一行
			}
			System.out.println();
		}
	}
}

class T{
	//使用递归回溯的思想来解决老鼠出迷宫问题
	//1. findWay方法是用来专门找出迷宫的路径
	//2. 如果找到就返回true，没有扎到就返回false
	//3. map 代表二维数组即迷宫
	//4. i和j代表老鼠的位置，初始化的位置为(1,1)点
	//5. 由于使用递归找路，所以规定map数组每一个值的含义
	//   0表示可以走;1表示障碍物;2表示可以走;3表示走过但是是死路
	//6. 当map[6][5] = 2 就说明找到通路,就可以结束,否则就继续找
	//7. 先确定老鼠的找路策略 下->右->上->左
	public boolean findWay(int[][] map, int i, int j){
		if(map[6][5] == 2){
			return true;
		}else {
			if(map[i][j] == 0){//当前这个位置为0，表示可以走
				//假定可以走通
				map[i][j] = 2;
				//使用找路策略类确定该位置是否真的可以走通
				//下->右->上->左
				if(findWay(map,i+1,j)){//先走下
					return true;
				}else if(findWay(map,i,j+1)){//右边
					return true;
				}else if(findWay(map,i,j+1)){//上
					return true;
				}else if(findWay(map,i,j+1)){//左
					return true;
				}else{
					map[i][j] = 3;
					return false;
				}
			}else{ //map[i][j] = 1,2,3
				return false;
			}
		}
		
	}
	//修改找路策略，看看路径是否变化
	//下->右->上->左 ===> 上->右->下->左
		public boolean findWay2(int[][] map, int i, int j){
		if(map[6][5] == 2){
			return true;
		}else {
			if(map[i][j] == 0){//当前这个位置为0，表示可以走
				//假定可以走通
				map[i][j] = 2;
				//使用找路策略类确定该位置是否真的可以走通
				//上->右->下->左
				if(findWay2(map,i-1,j)){//先走上
					return true;
				}else if(findWay2(map,i,j+1)){//右边
					return true;
				}else if(findWay2(map,i+1,j+1)){//下
					return true;
				}else if(findWay2(map,i,j+1)){//左
					return true;
				}else{
					map[i][j] = 3;
					return false;
				}
			}else{ //map[i][j] = 1,2,3
				return false;
			}
		}
		
	}
}