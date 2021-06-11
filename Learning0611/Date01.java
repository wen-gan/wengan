package com.wengan.Learning0611.Homework_Exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
/**
 * @author 文淦
 * @version 1.0
 */
public class Date01 {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        System.out.println("当前日期 = " + d1);

        //对日期格式要进行转换
        //这里的格式是确定的yy只能用yy...
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss E");
        String format = sdf.format(d1);
        System.out.println("当前日期 = " + format);

        String s = "1996年01月01日 10:20:30 星期一";
        Date parse = sdf.parse(s);
        System.out.println("parse = " + sdf.format(parse));

        //第二代日期类 Calendar是一个抽象类
        //可以通过 getInstance()来获取实例
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        //获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        System.out.println("月：" + (c.get(Calendar.MONTH)+1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calendar 没有专门的格式化方法，所以需要自己组合显示
        //24小时字段用HOUR_OF_DATE
        System.out.println(c.get(Calendar.YEAR) + "年" + (c.get(Calendar.MONTH)+1) + "月"
        + c.get(Calendar.DAY_OF_MONTH) + "日" + c.get(Calendar.HOUR_OF_DAY) + "时"
                + c.get(Calendar.MINUTE) + "分" + c.get(Calendar.SECOND) + "秒");

        //第三代日期类
        //获取日期+时间
        LocalDateTime ldt = LocalDateTime.now();
        //获取日期
        LocalDate ldt2 = LocalDate.now();
        //获取时间
        LocalTime ldt3 = LocalTime.now();
        System.out.println(ldt);
        System.out.println("年："+ldt.getYear());
        System.out.println("月："+ldt.getMonthValue());
        ldt.getYear();
        ldt.getMonthValue();
        ldt.getMonth();
        ldt.getDayOfMonth();
        ldt.getHour();
        ldt.getMinute();
        ldt.getSecond();
    }
}
