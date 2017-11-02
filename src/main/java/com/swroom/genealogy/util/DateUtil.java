package com.swroom.genealogy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * 日期工具类
 * Created by jingz on 2017/2/7.
 */
public class DateUtil {

    /**
     * 判断两个日期的大小
     *
     * @param bgdate
     * @param endate
     * @return 如果bgdate>endate,返回true，否则返回false
     */
    public static boolean isAfterDate(String bgdate, String endate) {
        String[] bg = bgdate.split(" ", -2);
        String[] end = endate.split(" ", -2);

        Calendar bgCal = getDate(bg[0]);
        Calendar edCal = getDate(end[0]);

        return bgCal.after(edCal);
    }

    /**
     * 判断某个日期是否在一个日期区间
     *
     * @param date   要判断的日期
     * @param bgdate 日期区间起点
     * @param endate 日期区间终点
     * @return
     */
    public static boolean isBetweenDate(String date, String bgdate, String endate) {
        if (isAfterDate(bgdate, date) && isAfterDate(date, endate)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 根据字符串日期返回日期对象
     *
     * @param date 日期标示 2007-01-02
     */
    public static Calendar getDate(String date) {
        if (date == null)
            return null;

        date = date.trim();
        if (date.length() == 7) {
            date += "-01";
        }

        StringTokenizer st = new StringTokenizer(date, "-");
        int year = 2100;
        int month = 0;
        int day = 1;

        try {
            year = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken()) - 1;
            day = Integer.parseInt(st.nextToken());
        } catch (Exception e) {
            return null;
        }
        return new GregorianCalendar(year, month, day);
    }

    /**
     * 根据日期对象返回字符串日期
     *
     * @param date 日期对象
     */
    public static String getDateStr(Calendar date) {
        if (date == null)
            return "";
        return (new SimpleDateFormat("yyyy-MM-dd")).format(date.getTime());
    }

    /**
     * Date转String
     * @param date date
     * @return yyyy-MM-dd
     */
    public static String getDateStr(Date date) {
        if (date == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    /**
     * 在现有日期时间增加N年N月N日
     *
     * @param dateTime 时间标示 2007-01-02
     * @param year     增加N年
     * @param month    增加N月
     * @param day      增加N日
     * @return 调整过得日期 2009-01-02 (不带时间)
     */
    public static String plusDates(String dateTime, int year, int month, int day) {
        StringTokenizer datest = new StringTokenizer(dateTime, " ");

        int newyear = 2100;
        int newmonth = 0;
        int newday = 1;

        try {

            StringTokenizer dates = new StringTokenizer(datest.nextToken(), "-");

            newyear = Integer.parseInt(dates.nextToken());
            newmonth = Integer.parseInt(dates.nextToken()) - 1;
            newday = Integer.parseInt(dates.nextToken());

        } catch (Exception e) {
            e.printStackTrace();
        }

        Calendar calendar = new GregorianCalendar(newyear, newmonth, newday);

        calendar.add(Calendar.YEAR, year);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, day);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.format(calendar.getTime());
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 获取开始时间
     *
     * @param begdate
     * @return
     */
    public static String getBegTime(String begdate) {
        if (!"".equals(begdate)) {
            return begdate + " 00:00:00";
        }
        return "";
    }

    /**
     * 获取开始时间
     *
     * @param enddate
     * @return
     */
    public static String getEndTime(String enddate) {
        if (!"".equals(enddate)) {
            return enddate + " 23:59:59";
        }
        return "";
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getTodaytime() {
        Calendar cl = new GregorianCalendar();
        return getToday() + " " + cl.get(Calendar.HOUR_OF_DAY) + ":" + cl.get(Calendar.MINUTE) + ":" + cl.get(Calendar.SECOND) + " ";
    }

    public static String getTodaytime(String splitDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + splitDate + "MM" + splitDate + "dd HH:mm:ss");
        Calendar cl = new GregorianCalendar();
        try {
            return sdf.format(cl.getTime());
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cl = new GregorianCalendar();
        try {
            return sdf.format(cl.getTime());
        } catch (Exception ex) {
            return null;
        }
    }

}
