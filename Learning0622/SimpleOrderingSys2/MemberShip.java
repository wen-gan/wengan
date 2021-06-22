package com.wengan.Learning0621.SimpleOrderingSys2;

/**
 * @author 文淦
 * @version 1.0
 */
public class MemberShip {
    private int memberNum;
    private String rank;
    private double cash;
    private double discount;

    @Override
    public String toString() {
        return "MemberShip{" +
                "memberNum=" + memberNum +
                ", rank='" + rank + '\'' +
                ", cash=" + cash +
                ", discount=" + discount +
                '}';
    }

    public MemberShip(int memberNum, String rank, double cash, double discount) {
        this.memberNum = memberNum;
        this.rank = rank;
        this.cash = cash;
        this.discount = discount;
    }

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
