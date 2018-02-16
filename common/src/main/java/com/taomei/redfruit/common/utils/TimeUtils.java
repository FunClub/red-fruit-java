package com.taomei.redfruit.common.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

/**
 * 时间工具类
 */
public class TimeUtils {
    private final static String DATE_TIME_PATTERN = "YYYY-MM-DD HH:MM:SS";
    private final static int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23,
            23, 23, 24, 23, 22 };

    private final static String[] START = new String[] { "摩羯座",
            "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座",
            "天蝎座", "射手座", "摩羯座" };

    private final static String[] STARTCHAR = new String[] { "mojie",
            "shuiping", "shuangyu", "baiyang", "jinniu", "shuangzi", "juxie", "shizi", "chunv", "tiancheng",
            "tianxie", "sheshou", "mojie" };

    private final static String[] CHINESE_ZODIAC = new String[] { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊",
            "猴", "鸡", "狗", "猪" };


    /**
     * 根据年龄计算出生日期字符串
     * @param ages 年龄
     * @return 出生日期字符串
     */
    public static String calculateDateByAge(String ages){
        Integer age = Integer.valueOf(ages);
        LocalDate now = LocalDate.now();
        Integer year = now.getYear()-age-1;
        LocalDate newDate = LocalDate.of(year,now.getMonthValue(),now.getDayOfMonth());
        newDate=newDate.plusDays(1);
        return newDate.getYear()+"-"+newDate.getMonthValue()+"-"+newDate.getDayOfMonth();
    }
    /**
     * 通过生日计算星座
     *
     * @param birthday 出生日期
     * @return 星座英文标识
     */
    public  static String calculateStartChar(String birthday) {
        LocalDate localDate = TimeUtils.generateLocalDate(birthday);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        return day < dayArr[month - 1] ? STARTCHAR[month - 1]
                : STARTCHAR[month];
    }

    /**
     * 通过生日计算星座
     *
     * @param birthday 出生日期
     * @return 星座
     */
    public static String calculateStart(String birthday) {
        LocalDate localDate = TimeUtils.generateLocalDate(birthday);
        int month = localDate.getMonthValue();
        int day = localDate.getDayOfMonth();
        return day < dayArr[month - 1] ? START[month - 1]
                : START[month];
    }

    /**
     * 通过年份计算生肖
     *
     * @param birthday 出生日期
     * @return 生肖
     */
    public static String calculateChineseZodiac(String birthday) {
        LocalDate localDate = TimeUtils.generateLocalDate(birthday);
        Integer year = localDate.getYear();
        if (year < 1900) {
            return "未知";
        }
        int start = 1900;
        return CHINESE_ZODIAC[(year - start) % CHINESE_ZODIAC.length];
    }
    /**
     * 根据生日计算年龄
     * @param birthday 生日
     * @return 年龄
     */
    public static Integer calculateAge(String birthday) {
        LocalDate date = generateLocalDate(birthday);
        LocalDate now = LocalDate.now();
        Period period = Period.between(date, now);
        return period.getYears();
    }

    /**
     * 根据生日生成 LocalDate
     *
     * @param birthday 生日
     * @return LocalDate
     */
    public static LocalDate generateLocalDate(String birthday) {

        String[] strings = birthday.split("-");
        LocalDate date = LocalDate.of(Integer.valueOf(strings[0]),
                Integer.valueOf(strings[1]), Integer.valueOf(strings[2]));
        return date;
    }

    /**
     * 生成文件名字所用时间
     *
     * @return
     */
    public static String generateFileTime() {
        LocalDateTime dateTime = LocalDateTime.now();

        return dateTime.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN)) + dateTime.hashCode();
    }

    public static String generateTime(String format) {
        Date date = new Date();
        SimpleDateFormat formats = new SimpleDateFormat(format);
        return formats.format(date);
    }

    public static String getSimpleTime() {
        return generateTime("yyyy-M-d HH:mm:ss");
    }

    /**
     * 获得现在多久的时间
     *
     * @param time 待计算的时间
     * @return 距离现在在多久的时间
     */
    public static String calculateHowLongAgo(String time) {
        Date calculateTime = null;
        Date nowTime = null;
        try {
            calculateTime = new SimpleDateFormat("yyyy-M-d HH:mm:ss")
                    .parse(time);
            nowTime = new SimpleDateFormat("yyyy-M-d HH:mm:ss")
                    .parse(getSimpleTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

        int second = (int) ((nowTime.getTime() - calculateTime.getTime()) / 1000);
        int minutes = second / 60;
        int hours = minutes / 60;
        int days = hours / 24;
        int months = days / 30;
        int years = days / 365;
        if (minutes == 0) {
            return second + "秒";
        } else if (hours == 0) {
            return minutes + "分钟";
        } else if (days == 0) {
            return hours + "小时";
        } else if (months == 0) {
            return days + "天";
        } else if (years == 0) {
            return months + "个月";
        } else {
            return years + "年";
        }

    }

    /**
     * 获取分门别类的时间
     *
     * @param date 日期
     * @return 分门别类的时间
     */
    public static String calculateSortDate(String date) {
        String howLongAgo = calculateHowLongAgo(date);
        int howLongLength = howLongAgo.length();
        int dateLength = date.length();
        char lastHowLong = howLongAgo.charAt(howLongLength - 1);
        char firstHowLong = howLongAgo.charAt(0);
        //截取年月日
        StringBuilder sb = new StringBuilder(date);
        int blackChar = sb.indexOf(" ");
        String yyd = sb.delete(blackChar, date.length()).toString();

        //截取月日
        String yd = yyd.substring(5, blackChar);
        if (lastHowLong == '年') {
            return yyd;
        } else if (lastHowLong == '月') {
            return yd;
        } else if (lastHowLong == '天') {
            if (howLongLength == 2) {
                if (firstHowLong == '1') {
                    return "昨天";
                } else if (firstHowLong == '2') {
                    return "前天";
                }
            }
            return yd;
        } else {
            return "今天";
        }

    }

    /**
     * 获取简短日期比如2017-12-12 12:23:15 的简短日期是12:23
     *
     * @param date
     * @return
     */
    public static String generateShortDate(String date) {
        int blackChar = new StringBuilder(date).indexOf(" ");
        return date.substring(blackChar + 1, date.length() - 3);
    }

}
