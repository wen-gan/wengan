package com.wengan.HouseRent;

public class Utility {

    public static int readInt(){
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, false);
            try{
                n = Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    public static char readConfirmSelection(){
        System.out.println("请输入您的选择(Y/N)：");
        char c;
        for (; ;) {//无限循环
            //在这里，将接受到字符转成了大写字母
            //y => Y n => N
            String str = readKeyBoard(1,false).toUpperCase();
            c = str.charAt(0);
            if(c == 'Y' || c == 'N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }
}
