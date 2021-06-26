package com.wengan.Learning0621.SimpleOrderingSysNew;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 文淦
 * @version 1.0
 */
public class DateTool {
    //对时间进行格式化
    private static SimpleDateFormat sdf = new SimpleDateFormat();
    public static String getDate() {
        sdf.applyPattern("MMdd");
        Date date = new Date();
        return sdf.format(date);
    }

    public static String getPresentTime() {
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");//最后的 a代表am/pm
        Date date = new Date();// 获取当前时间
        return sdf.format(date); // 输出已经格式化的现在时间（24小时制）
    }
}
