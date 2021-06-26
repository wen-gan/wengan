package com.wengan.Learning0621.SimpleOrderingSysNew;

import com.wengan.Learning0621.SimpleOrderingSystem.Utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings("all")
public class OrderingView {
    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接受用户输入
    private OrderingService orderingService = new OrderingService(10);//调用订单相关方法
    private MemberService memberService = new MemberService(20);//调用会员相关方法
    private Dishs[] dishs = Dishs.values();//菜单
    private double turnover = 6;//营业额
    private int orderTotal = 1;//总订单数
    private long timeConsumTotal;//点餐耗时
    private double discountCashTotal;//折扣总金额
    private List dishName = new ArrayList();//点过的菜品
    private List present = new ArrayList();//赠送的菜品
    private List member = new ArrayList();//会员
    private List dishPrice = new ArrayList();//保存点餐的各个菜品的价格


    //记录未完成状态的订单个数
    int stateUnfin = 0;

    //修改订单
    public void reviseOrder(){
        System.out.println("====修改订单信息====");
        System.out.println("请选择需要修改的订单编号(-1表示退出)：");
        int reviseNum = Utility_order.readInt();
        if (reviseNum == -1) {
            System.out.println("====放弃修改订单信息====");
            return;
        }

        //查找订单
        Order order = orderingService.find(reviseNum);
        if (order == null) {
            System.out.println("====修改的订单不存在====");
            return;
        }
        //逐项修改
        System.out.println("菜品(" + order.getDishDetails().getName() + ")：");
        //直接输入回车表示不修改信息
        String dish = Utility_order.readString(12," ");
        System.out.println("规格(" + order.getDishDetails().getSpe() + ")：");
        int spe = Utility_order.readInt(-1);
        System.out.println("数量(" + order.getDishDetails().getNums() + ")：");
        int nums = Utility_order.readInt(-1);

        if (!" ".equals(dish) && !"".equals(spe) && !"".equals(nums)) {
            order.setDishDetails(new Dishes(dish, spe, nums));
        }

        System.out.println("订单状态(" + order.getState() + ")：");
        String state = Utility_order.readString(3," ");
        if (!"".equals(state)) {
            order.setState(state);
        }

        System.out.println("折扣信息(" + order.getDiscount() + ")：");
        int discount = Utility_order.readInt(-1);
        if (!"".equals(discount)) {
            order.setDiscount(discount);
        }

        System.out.println("实际付款(" + order.getActualAmount() + ")：");
        int actualAmount = Utility_order.readInt(-1);
        if (!"".equals(actualAmount)) {
            order.setActualAmount(actualAmount);
        }

        System.out.println("====订单信息修改成功====");
    }

    //删除订单信息
    public void delOrders() {
        System.out.println("====删除订单信息====");
        System.out.println("请输入待删除的订单编号(-1退出)：");
        int delOrdernum = Utility_order.readInt();
        if (delOrdernum == -1){
            System.out.println("====放弃删除订单信息====");
            return;
        }

        char choice = Utility_order.readConfirmSelection();
        if (choice == 'Y') {
            if (orderingService.del(delOrdernum)) {
                orderTotal -= 1;
                System.out.println("====订单删除成功====");
            }else {
                System.out.println("====订单不存在====");
            }
        }else {
            System.out.println("====放弃删除订单信息====");
        }
    }

    //点餐(添加订单信息)
    public void addOrders() throws Exception {
        //开始点餐
        Date dateStr = new Date();

        System.out.println("====点餐====");
        System.out.println("菜品：");
        String dish = Utility_order.readString(20);
        System.out.println("份数：");
        int num = Utility_order.readInt();

        //将点过的菜品存入ArrayList
        dishName.add(dish);

        //初始化菜品规格
        int spe_ = 0;
        //点餐 点过一次便减少相应菜品份数
        for (Dishs dish_ : dishs) {
            if(dish_.getName().equals(dish)){
                System.out.println("找到该菜品");
                if (dish_.getTimes() == 0) {
                    System.out.println("该菜品已卖完，请选择其他菜品");
                    return;
                }else {
                    if (dish_.getTimes()-num < 0){
                        System.out.println("该菜品已不足，请选择其他菜品");
                        return;
                    }
                    dish_.setTimes(dish_.getTimes()-num);
                    System.out.println("该菜品还剩" + dish_.getTimes() + "份");
                    spe_ = dish_.getSpe();
                }
            }
        }

//        System.out.println("规格：");
//        int spe = Utility_order.readInt();
        System.out.println("状态：");
        String state = Utility_order.readString(5," ");
        System.out.println("折扣信息：");
        double discount = Utility_order.readInt(1);
        System.out.println("实际付款：");
        int actualAmount = Utility_order.readInt();
//        System.out.println("会员编号：(若不是会员请输入0)");
//        String memberNum = Utility_order.readString(8," ");

        //点餐结束时间
        Date dateFin = new Date();

        Order newOrder = new Order(0, 1, new Dishes(dish, spe_, num), dateStr, state ,dateFin,
                discount, actualAmount);
        //计算营业额
        turnover += actualAmount;
        System.out.println("====当前营业额" + turnover + "元====");
        //计算点餐耗时
        long timeConsum = (dateFin.getTime() - dateStr.getTime()) / 1000;
        System.out.println("====本次点餐耗时" + timeConsum + "秒====");
        timeConsumTotal += timeConsum;
        //计算折扣金额
        double discountCash = spe_ * num * (1 - discount / 10);
        discountCashTotal += discountCash;

        //判断是否为会员
        System.out.println("是否为店铺会员？(是会员请输入y，不是会员请输入n)");
        char choice1 = Utility.readConfirmSelection();
        if (choice1 == 'Y') {
            System.out.print("请输入会员编号：");
            String memberID = Utility.readString(7);
            memberID = "会员" + memberID;

            newOrder.setMembernum(memberID);

            newOrder.setActualAmount(newOrder.getTotalAmount() *(1 - newOrder.getDiscount() / 10));
        } else if (choice1 == 'N') {
            System.out.println("请问是否充值办理店铺会员？");
            char choice2 = Utility.readConfirmSelection();
            if (choice2 == 'Y') {
                MemberShip newMember = creatMember();
                joinMember(newMember);
                newOrder.setMembernum(newMember.getMemberNum());
                newOrder.setDiscount(newMember.getDiscount());
                newOrder.setActualAmount(newOrder.getTotalAmount() * newOrder.getDiscount());
            } else {
                newOrder.setActualAmount(newOrder.getTotalAmount());
            }
        }
        if (orderingService.add(newOrder)) {
            orderTotal += 1;
            System.out.println("====订单添加成功====");
            if (newOrder.getTotalAmount() > 100) {
                System.out.println("====消费超过100元，赠送一份低于10元的菜品--->蛋炒饭(6)====");
                present.add("蛋炒饭(6)");
            }
        }else {
            System.out.println("====订单添加失败====");
        }
    }

    // 创建新会员
    public MemberShip creatMember() {
        System.out.println("====加入会员====");
        System.out.print("请输入充值金额：");
        double cash = Utility.readInt();
        return new MemberShip(cash);
    }

    // 加入会员大家庭
    public void joinMember(MemberShip member) throws Exception {
        if (memberService.addNewMember(member)) {
            System.out.println("恭喜您！成功加入会员大家庭！");
        } else {
            System.out.println("抱歉，会员加入失败...");
        }
    }

    //退出系统
    public void exit(){
        char c = Utility_order.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
    }
    //查找订单信息
    public void findOrder() {
        System.out.println("====查找订单信息====");
        System.out.println("请输入要查找的订单号：");
        int findOrdernum = Utility_order.readInt(-1);
        System.out.println("订单编号\t\t排队序号\t\t\t菜品详情\t\t\t\t\t\t订单生成时间\t\t\t订单状态(已完成/未完成)\t\t\t订单完成时间" +
                "\t\t\t订单总金额\t\t折扣信息\t实付款\t会员编号");
        Order order = orderingService.find(findOrdernum);
        //查找的订单信息存在便进行输出
        if (order != null) {
            System.out.println(order);
        }else {
            System.out.println("====查找的订单信息不存在====");
        }
    }
    //显示订单信息
    public void display(){
        System.out.println("====订单信息====");
        System.out.println("订单编号\t\t排队序号\t\t\t菜品详情\t\t\t\t\t\t订单生成时间\t\t\t订单状态(已完成/未完成)\t\t\t订单完成时间" +
                "\t\t\t订单总金额\t\t折扣信息\t实付款\t会员编号");
        Order[] orders = orderingService.list();

        for (int i = 0; i < orders.length ; i++) {
            if (orders[i] == null) {
                break;
            }
            //如果订单显示为未完成便进行记录
            if (orders[i].getState().equals("未完成")){
                stateUnfin += 1;
            }
            dishPrice.add(orders[i].getTotalAmount());
            System.out.println(orders[i]);
        }

        dishName.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String name1 = (String) o1;
                String name2 = (String) o2;
                //按照菜品名的长度进行排序
                return name1.length() - name2.length();//从小到大排列
//                return name2.length() - name1.length();//从大到小排列
            }
        });

        //打印所有的信息
        System.out.println("====所有订单总耗时" + timeConsumTotal + "秒====");
        System.out.println("====平均每单耗时" + (timeConsumTotal/orderTotal) + "秒====");
        System.out.println("====当前共有订单" + orderTotal + "个====");
        System.out.println("====未完成订单共有" + stateUnfin + "个，分别为====");
        System.out.println("订单编号\t\t排队序号\t\t\t菜品详情\t\t\t\t\t\t订单生成时间\t\t\t订单状态(已完成/未完成)\t\t\t订单完成时间" +
                "\t\t\t订单总金额\t\t折扣信息\t实付款\t会员编号");
        for (int i = 0; i < orders.length ; i++) {
            if (orders[i] == null) {
                break;
            }
            //如果订单显示为未完成便进行记录
            if (orders[i].getState().equals("未完成")){
                stateUnfin += 1;
                System.out.println(orders[i]);
            }
        }
        System.out.println("====订单信息显示完毕====");
    }

    public void cashCal(){
        System.out.println("====当前总营业额为" + turnover + "元====");
        System.out.println("====当前平均每单消费额为" + (turnover/orderTotal) + "元====");
        System.out.println("====总折扣金额为" + discountCashTotal + "元====");
    }

    public void dishCal(){
        System.out.println("====今日消费菜品有：" + dishName + "====");
        System.out.println("====菜品对应消费为：" + dishPrice + "====");
        System.out.println("====今日赠送菜品详情：" + present + "====");
    }

    //根据菜名显示菜品的供应情况
    public void findDish() {
        System.out.println("====查看菜品供应情况====");
        System.out.println("请输入要查找的菜品名：");
        String dishFind = Utility_order.readString(20, " ");

        for (Dishs dish_ : dishs) {
            if (dish_.getName().equals(dishFind)) {
                System.out.println("菜品名：" + dish_.getName());
                System.out.println("剩余菜品供应量：" + dish_.getTimes());
                return;
            }else {
                System.out.println("该菜品不在菜单内，请重新输入...");
            }
        }
        System.out.println("====菜品供应情况显示完毕====");
    }

    //显示主菜单
    public void mainMenu() throws Exception {
        do {
            System.out.println("===========菜单===========");
            System.out.println("===========主食===========");
            System.out.println("素三鲜水饺        12元/斤");
            System.out.println("酸菜油吱啦        12元/斤");
            System.out.println("猪肉              16元/斤");
            System.out.println("汤饺(肉)          5元");
            System.out.println("汤饺(素)          5元");
            System.out.println("米饭(小碗)        2元");
            System.out.println("米饭(大碗)        3元");
            System.out.println("面条(小碗)        2元");
            System.out.println("面条(中碗)        3元");
            System.out.println("面条(大碗)        4元");
            System.out.println("饹豆子(小碗)      2元");
            System.out.println("饹豆子(大碗)      3元");
            System.out.println("鸡蛋炒面          6元");
            System.out.println("火腿炒面          6元");
            System.out.println("肉炒面            7元");
            System.out.println("蛋炒饭            6元");
            System.out.println("扬州炒饭          7元");
            System.out.println("担担面(小碗)      4元");
            System.out.println("担担面(小碗)      5元");
            System.out.println("===========鱼类===========");
            System.out.println("鲤鱼              30元");
            System.out.println("刀鱼              16元");
            System.out.println("小黄鱼            30元");
            System.out.println("青鱼              30元");
            System.out.println("====简易点餐系统====");
            System.out.println("  1 点        餐");
            System.out.println("  2 查看订单信息");
            System.out.println("  3 修改订单信息");
            System.out.println("  4 删除订单信息");
            System.out.println("  5 查找订单信息");
            System.out.println("  6 菜品供应情况");
            System.out.println("  7 营业统计情况");
            System.out.println("  8 菜品处理情况");
            System.out.println("  9 退        出");

            System.out.print("请输入你的选择(1-9)：");
            key = Utility_order.readChar();
            switch (key) {
                case '1':
                    addOrders();
                    break;
                case '2':
                    display();
                    break;
                case '3':
                    reviseOrder();
                    break;
                case '4':
                    delOrders();
                    break;
                case '5':
                    findOrder();
                    break;
                case '6':
                    findDish();
                    break;
                case '7':
                    cashCal();
                    break;
                case '8':
                    dishCal();
                    break;
                case '9':
                    exit();
                    break;
            }
        }while(loop);
    }
}
