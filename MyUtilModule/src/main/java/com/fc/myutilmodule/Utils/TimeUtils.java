package com.fc.myutilmodule.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class TimeUtils {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT_yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT_yyyy_MM_dd_HH_mm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat DEFAULT_DATE_FORMAT_yyyy_MM_dd    = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DATE_FORMAT_DATEMMDD    = new SimpleDateFormat("MM-dd");
    public static final SimpleDateFormat DATE_FORMAT_DATEYYYYMM    = new SimpleDateFormat("yyyy-MM");
    public static final SimpleDateFormat DATE_FORMAT_DATEYYYYMMDDHHMMSSS = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat DATE_FORMAT_CHINADATE    = new SimpleDateFormat("yyyy年MM月dd日");
    public static final SimpleDateFormat DATE_FORMAT_DATEYYYYMMDD = new SimpleDateFormat("yyyyMMdd");


    private TimeUtils() {
        throw new AssertionError();
    }

    /**
     * Long 型时间转换为String  dateFormat为转换的格式
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * （String 类型的long型时间转换为String  dateFormat为转换的格式
     * @param timeInMillisStr
     * @param dateFormat
     * @return
     */
    public static String getTime(String timeInMillisStr,SimpleDateFormat dateFormat){
        try {
            long timeInMillis = Long.parseLong(timeInMillisStr);
            return getTime(timeInMillis, dateFormat);
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 获取自己定义的时间String 格式  如 yyyy:MM:dd
     * @param format
     * @return
     */
    public static final DateFormat getFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * Date 转换为 String格式
     * @param date
     * @param dateFormat
     * @return
     */
    public static String dtFormat(Date date, String dateFormat){
        return getFormat(dateFormat).format(date);
    }

   //例如yyyy:MM:dd 类型的时间格式转换为Date  formatType为时间格式
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        return getFormat(formatType).parse(strTime);
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }







    /**
     * 得到现在时间
     * 得到Date类型的时间
     * @return
     */
    public static Date getNow() {
        Date currentTime = new Date();
        return currentTime;
    }

    /**
     * 得到几天后的时间
     * 得到date类型的时间
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day){
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
        return now.getTime();
    }

    /**
     * 得到今天起几天后的时间
     * 得到Date类型的时间
     * @param day
     * @return
     */
    public static Date getDateAfter(int day){
        Calendar now = Calendar.getInstance();
        now.setTime(getNow());
        now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
        return now.getTime();
    }

    /**
     * 得到今天起几天后的时间
     * +7 后一周  -7 前一周
     * +1前一天 -1 后一天
     * @param day
     * @return
     */
    public static String getEveryDay(int day, Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE,now.get(Calendar.DATE)+day);
        return format.format(now.getTime());
    }


    /**
     * 获取每月第一天
     * times -为前  times+后
     * @param times
     * @return
     */
    public static String getEveryMonthFirstDay(int times, Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取前月的第一天
        Calendar cal_1= Calendar.getInstance();//获取当前日期
        cal_1.setTime(date);//设置时间
        cal_1.add(Calendar.MONTH, times);
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return format.format(cal_1.getTime());
    }

    /**
     * 获取设置时间的前一个月
     * @param times
     * @param date
     * @return
     */
    public static String getEveryMonth(int times, Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        //获取前月的第一天
        Calendar cal_1= Calendar.getInstance();//获取当前日期
        cal_1.setTime(date);//设置时间
        cal_1.add(Calendar.MONTH, times);
//        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        return format.format(cal_1.getTime());
    }


    /**
     * 根据Date 判断是第几周
     * @param date
     * @return
     */
    public static String getdayForWeek(Date date){
        Calendar cal_1= Calendar.getInstance();//获取当前日期
        cal_1.setTime(date);//设置时间
        return "第"+cal_1.get(Calendar.WEEK_OF_YEAR)+"周";

    }




    /*
           * 将秒数转为时分秒
           * */
    public static String getSecondTimeToDDHHmmss(long second) {
        long h = 0;
        long d = 0;
        long s = 0;
        long dd = 0;
        long temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        if(h/24 < 1){
            dd =0;
        }else{
            dd = h/24;
            h = h - dd*24 ;
        }
        String result;
        if(dd==0){
            result =  h + ":" + d + ":" + s + "";
        }else{
            result = dd + ":" + h + ":" + d + ":" + s + "";
        }
        return result;
    }

    /*
        * 将秒数转为时分秒
        * */
    public static String getSecondTimeToHHmmss(long second) {
        long h = 0;
        long d = 0;
        long s = 0;
        long temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        return h + ":" + d + ":" + s + "";
    }

    /*
    * 将秒数转为时分秒
    * */
    public static String getSecondTimeTommss(long second) {
        long h = 0;
        long d = 0;
        long s = 0;
        long temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        if(h>0){
            d = 60*h + d;
        }

        return d + ":" + s + "";
    }








    public static boolean isOverdue(String timeInMillis2){
        long timeLong2 =0;
        try {
            Date date = null;
            date = DEFAULT_DATE_FORMAT_yyyy_MM_dd_HH_mm.parse(timeInMillis2);
            timeLong2 = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long between = (getCurrentTimeInLong() - timeLong2);
        return between > 0;
    }

    public static boolean isOverdue(long timeInMillis2){
        int between = (int)(getCurrentTimeInLong() - timeInMillis2);
        return between > 0;
    }
}
