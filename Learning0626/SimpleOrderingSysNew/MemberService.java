package com.wengan.Learning0621.SimpleOrderingSysNew;

/**
 * @author 文淦
 * @version 1.0
 */
public class MemberService {
    private MemberShip[] members;
    private int memberNum = 0;
    private int memberCount = 0;//记录当前会员的个数

    public MemberService(int size) {
        members = new MemberShip[size];
        members[0] = new MemberShip(300);
    }

    //添加会员信息
    public boolean addNewMember(MemberShip newmember) {
        if (newmember.getCash() <= 0) {
            System.out.println("抱歉，输入金额有误...");
            return false;
        }
        newmember.setMemberNum("会员" + (++memberNum));
        members[0] = new MemberShip(100);
        members[memberCount++] = newmember;
        return true;
    }
}
