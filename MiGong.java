//�Թ�����
//
public class MiGong{
	public static void main(String[] args){
		//	˼·
		//1. �ȴ����Թ����ö�ά�����ʾ�� int[][] map = new int[8][9]
		//2. �ٹ涨 map �����Ԫ��ֵ��0 ��ʾ������; 1 ��ʾ�ϰ���
		
		int[][] map = new int[8][7];
		//3. ���������һ�к��������һ��ȫ������Ϊ1
		for(int i = 0; i<7 ; i++){
			map[0][i] = 1;
			map[7][i] = 1;
		}
		//4. �����ұߵ�һ�к�����ߵ�һ��ȫ������Ϊ1
		for(int i=0;i<8;i++){
			map[i][0]=1;
			map[i][6]=1;
		}
		//�ϰ��������
		map[3][1] = 1;
		map[3][2] = 1;
		map[2][2] = 1;
		//�����ǰ��ͼ
		System.out.println("====��ǰ��ͼ���====");
		for(int i=0; i<map.length ; i++){
			for(int j=0 ; j<map[i].length;j++){
				System.out.print(map[i][j] + " ");//���һ��
			}
			System.out.println();
		}

		//ʹ��findWay��������·
		T t1 = new T();
		t1.findWay(map,1,1);

		System.out.println("====��·���������====");
		for(int i=0; i<map.length ; i++){
			for(int j=0 ; j<map[i].length;j++){
				System.out.print(map[i][j] + " ");//���һ��
			}
			System.out.println();
		}
	}
}

class T{
	//ʹ�õݹ���ݵ�˼�������������Թ�����
	//1. findWay����������ר���ҳ��Թ���·��
	//2. ����ҵ��ͷ���true��û�������ͷ���false
	//3. map �����ά���鼴�Թ�
	//4. i��j���������λ�ã���ʼ����λ��Ϊ(1,1)��
	//5. ����ʹ�õݹ���·�����Թ涨map����ÿһ��ֵ�ĺ���
	//   0��ʾ������;1��ʾ�ϰ���;2��ʾ������;3��ʾ�߹���������·
	//6. ��map[6][5] = 2 ��˵���ҵ�ͨ·,�Ϳ��Խ���,����ͼ�����
	//7. ��ȷ���������·���� ��->��->��->��
	public boolean findWay(int[][] map, int i, int j){
		if(map[6][5] == 2){
			return true;
		}else {
			if(map[i][j] == 0){//��ǰ���λ��Ϊ0����ʾ������
				//�ٶ�������ͨ
				map[i][j] = 2;
				//ʹ����·������ȷ����λ���Ƿ���Ŀ�����ͨ
				//��->��->��->��
				if(findWay(map,i+1,j)){//������
					return true;
				}else if(findWay(map,i,j+1)){//�ұ�
					return true;
				}else if(findWay(map,i,j+1)){//��
					return true;
				}else if(findWay(map,i,j+1)){//��
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
	//�޸���·���ԣ�����·���Ƿ�仯
	//��->��->��->�� ===> ��->��->��->��
		public boolean findWay2(int[][] map, int i, int j){
		if(map[6][5] == 2){
			return true;
		}else {
			if(map[i][j] == 0){//��ǰ���λ��Ϊ0����ʾ������
				//�ٶ�������ͨ
				map[i][j] = 2;
				//ʹ����·������ȷ����λ���Ƿ���Ŀ�����ͨ
				//��->��->��->��
				if(findWay2(map,i-1,j)){//������
					return true;
				}else if(findWay2(map,i,j+1)){//�ұ�
					return true;
				}else if(findWay2(map,i+1,j+1)){//��
					return true;
				}else if(findWay2(map,i,j+1)){//��
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