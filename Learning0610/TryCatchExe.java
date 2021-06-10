package com.wengan.Learning0610;

/**
 * @author 文淦
 * @version 1.0
 */
public class TryCatchExe {
    public static void main(String[] args){
        System.out.println(method());
    }

    public static int method(){
        int i = 1;
        try {
            i++;
            String[] names = new String[3];
            if(names[1].equals("tom")){
                System.out.println(names[1]);
            }else {
                names[3] = "wengan";
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 2;
        }catch (NullPointerException e){
            return ++i;
        }finally {
            return i++;
        }
    }
}
