package com.wengan.Learning0621.SimpleOrderingSysNew;

/**
 * @author 文淦
 * @version 1.0
 */
public class MemberShip {
    private String memberNum;//会员编号
    private String rank;//会员等级
    private double cash;//会员充值金额
    private double remainCash;//会员余额
    private double memberdiscount;//会员折扣
    @Override
    public String toString() {
        return "会员{" +
                "会员编号=" + memberNum +
                ", 等级='" + rank + '\'' +
                ", 余额=" + cash +
                ", 折扣=" + memberdiscount +
                '}';
    }

    public MemberShip(double cash) {
        this.cash = cash;
        if (cash >= 500) {
            this.memberdiscount = 0.9;
            rank = "金卡会员";
        }else if (cash >= 300 && cash <500 ) {
            this.memberdiscount = 0.8;
            rank = "银卡会员";
        }else if (cash > 0 && cash < 300) {
            this.memberdiscount = 0.7;
            rank = "普通会员";
        }
    }

    //会员消费扣费机制
    public double consume(double consumeTotal){
        double actualConsume = consumeTotal * memberdiscount;
        if (actualConsume > remainCash) {
            System.out.println("余额不足，请及时充值...");
            return -1;
        }else {
            this.remainCash -= actualConsume;
            System.out.println("付款成功，实际付款：" + actualConsume + "元");
            System.out.println("会员账户余额：" + getCash());
            return actualConsume;
        }
    }

    //会员充值机制
//    public void updateCash(double updateMoney) {
//        this.cash += updateMoney;
//        renewRank();
//    }

    //会员等级更新机制
    //设定充值超过500元及其以上为金卡会员
    //设定充值为300元至500元为银卡会员
    //设定充值为0元到300元为普通会员
//    public void renewRank() {
//        if (cash >= 500) {
//            this.discount = 0.9;
//            rank = "金卡会员";
//        }else if (cash >= 300 && cash <500 ) {
//            this.discount = 0.8;
//            rank = "银卡会员";
//        }else if (cash > 0 && cash < 300) {
//            this.discount = 0.7;
//            rank = "普通会员";
//        }
//    }

    public String getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(String memberNum) {
        this.memberNum = memberNum;
    }

    public String getRank() {
        return rank;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getDiscount() {
        return memberdiscount;
    }

    public double getRemainCash() {
        return remainCash;
    }

    public void setRemainCash(double remainCash) {
        this.remainCash = remainCash;
    }
}
