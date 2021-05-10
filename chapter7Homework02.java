//编写类A02，定义方法find
//实现查找某字符串数组中的元素查找
//并返回索引，如果找不到就返回-1
public class chapter7Homework02{
	public static void main(String[] args){
		A02 a = new A02();
		String strs[] = {"jack", "tom", "marry", "milan"};
		System.out.println("索引值为" + a.find(strs,"marry"));
	}
}

class A02 {
	public int find(String s[],String c){
		//遍历字符串数组，如果找到就返回索引
		for(int i=0; i<s.length ; i++){
			if(c.equals(s[i])){
				return i;
			}
		}
		return -1;
	}
}