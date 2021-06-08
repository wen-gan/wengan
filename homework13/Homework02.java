package com.wengan.homework;

public class Homework02 {
    public static void main(String[] args){
        String name = "jack";
        String pwd = "123456";
        String email = "jack@163.com";
        try {
            userRegister(name,pwd,email);
            System.out.println("恭喜注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String name, String pwd, String email){
        int userLength = name.length();
        if(!(userLength>=2 && userLength <= 4)){
            throw new RuntimeException("用户名长度不对");
        }
        if(!(pwd.length() == 6 && isDigital(pwd))){
            throw new RuntimeException("密码长度为6，要求全是数字");
        }
        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if(!(i>0 && j>i)){
            throw new RuntimeException("邮箱不对");
        }
    }

    public static boolean isDigital(String str){
        char chars[] = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] < '0' || chars[i] > '9'){
                return false;
            }
        }
        return true;
    }
}
