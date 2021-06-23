package com.wengan.Learning0621.SimpleOrderingSys2;

/**
 * @author 文淦
 * @version 1.0
 */
public class MemberShip {
    private int memberNum;//会员编号
    private String rank;//会员等级
    private double cash;//会员余额
    private double discount;//会员折扣

    @Override
    public String toString() {
        return "会员{" +
                "会员编号=" + memberNum +
                ", 等级='" + rank + '\'' +
                ", 余额=" + cash +
                ", 折扣=" + discount +
                '}';
    }

    public MemberShip(int memberNum, String rank, double cash) {
        this.memberNum = memberNum;
        this.rank = rank;
        this.cash = cash;
    }

    //会员消费扣费机制
    public double consume(double consumeTotal){
        double actualConsume = consumeTotal * discount;
        if (actualConsume > cash) {
            System.out.println("余额不足，请及时充值...");
            return -1;
        }else {
            this.cash -= actualConsume;
            System.out.println("付款成功，实际付款：" + actualConsume + "元");
            System.out.println("会员账户余额：" + getCash());
            return actualConsume;
        }
    }

    //会员充值机制
    public void updateCash(double updateMoney) {
        this.cash += updateMoney;
        renewRank();
    }

    //会员等级更新机制
    //设定充值超过500元及其以上为金卡会员
    //设定充值为300元至500元为银卡会员
    //设定充值为0元到300元为普通会员
    public void renewRank() {
        if (cash >= 500) {
            this.discount = 0.7;
            rank = "金卡会员";
        }else if (cash >= 300 && cash <500 ) {
            this.discount = 0.8;
            rank = "银卡会员";
        }else if (cash > 0 && cash < 300) {
            this.discount = 0.7;
            rank = "普通会员";
        }
    }

    public int getMemberNum() {
        return memberNum;
    }

    public String getRank() {
        return rank;
    }

    public double getCash() {
        return cash;
    }

    public double getDiscount() {
        return discount;
    }


}
