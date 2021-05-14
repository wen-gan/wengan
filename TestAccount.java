package com.wengan.encapsulation;

public class TestAccount {
    public static void main(String[] args){
        Account account = new Account();
        account.setName("jacksmith");
        account.setBalance(10);
        account.setPwd("123");
        account.show();


    }
}
