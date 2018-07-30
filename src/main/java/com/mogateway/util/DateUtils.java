package com.mogateway.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Pattern;

public class DateUtils {

    public static final String DEFAULT_VALID_TIME = "2099-12:30 00:00:00";

    final static public String FULL_ST_FORMAT = "yyyy-MM-dd HH:mm:ss";
    final static public String FULL_J_FORMAT = "yyyy/MM/dd HH:mm:ss";
    final static public String CURRENCY_ST_FORMAT = "yyyy-MM-dd HH:mm";
    final static public String CURRENCY_J_FORMAT = "yyyy/MM/dd HH:mm";
    final static public String DATA_FORMAT = "yyyyMMddHHmmss";
    final static public String ST_FORMAT = "yyyy-MM-dd HH:mm";
    final static public String ST_CN_FORMAT = "yyyy年MM月dd日 HH:mm";
    final static public String CN_FORMAT = "yy年MM月dd日HH:mm";
    final static public String DAY_FORMAT = "yyyy-MM-dd";
    final static public String SHORT_DATE_FORMAT = "yy-MM-dd";
    final static public String YEAR_FORMAT = "yyyy";
    private static SimpleDateFormat yyyyMMdd_HHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 获取当前时间
     * @return
     */
    public static String getNow(){
        return DateTime.now().toString(DateTimeFormat.forPattern(ST_FORMAT));
    }

    public static int getSeconds(){
        return (int)(DateTime.now().getMillis()/1000);
    }

    public static String getNow(String format){
        return DateTime.now().toString(DateTimeFormat.forPattern(format));
    }


    /**
     * 获取当前时间
     * @return
     */
    public static String getString(DateTime dt){
        return dt.toString(DateTimeFormat.forPattern(ST_FORMAT));
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getFullString(DateTime dt){
        return dt.toString(DateTimeFormat.forPattern(FULL_ST_FORMAT));
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getFullStringByDate(Date dt){
        return yyyyMMdd_HHmmss.format(dt);
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getString(Date d){
        DateTime dt = new DateTime(d);
        return dt.toString(DateTimeFormat.forPattern(ST_FORMAT));
    }    /**
     * 获取当前时间
     * @return
     */
    public static String getNowString(Date d){
        DateTime dt = new DateTime(d);
        return dt.toString(DateTimeFormat.forPattern(FULL_ST_FORMAT));
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getDayString(DateTime dt){
        return dt.toString(DateTimeFormat.forPattern("yyyy-MM-dd"));
    }


    /**
     * 将字符串转为DateTime
     * @param datestr
     * @return
     */
    public static DateTime getDateTime(String datestr){

        DateTimeFormatter df = DateTimeFormat.forPattern(ST_FORMAT);
        DateTime d = df.parseDateTime(datestr);

        return d;

    }

    /**
     * 将字符串转为DateTime
     * @param datestr
     * @return
     */
    public static DateTime getDateTime(String datestr,String format){

        DateTimeFormatter df = DateTimeFormat.forPattern(format);
        DateTime d = df.parseDateTime(datestr);

        return d;

    }

    /**
     * 当前时间加天数
     * @param days
     * @return
     */
    public static DateTime afterNdays(int days){
        return DateTime.now().plusDays(days);
    }

    /**
     * 当前时间加天数
     * @param hours
     * @return
     */
    public static DateTime afterNHours(int hours){
        return DateTime.now().plusHours(hours);
    }


    /**
     * 格式转换
     */
    public static String convertFormat(String date,String oldFrmat,String newFormat){
        DateTime dt = getDateTime(date,oldFrmat);
        return dt.toString(DateTimeFormat.forPattern(newFormat));
    }

    /**
     *通过秒数获取时间字符串
     * @param seconds
     * @return
     */
    public static String getStringBySecond(int seconds){

        long t = ((long)seconds)*1000;
        DateTime dt = new DateTime(t);
        return dt.toString(DateTimeFormat.forPattern(FULL_ST_FORMAT));
    }
    /**
     *通过毫秒数获取时间字符串
     * @param millisecond 毫秒数
     * @return
     */
    public static String getStringByMilliSecond(long millisecond){
        DateTime dt = new DateTime(millisecond);
        return dt.toString(DateTimeFormat.forPattern(FULL_ST_FORMAT));
    }


    public static void main(String[] args) {
        String time = getStringBySecond(1450143007);
        System.out.print(time);
    }

    public static String dateFormat(String dateTime,String format) throws Exception{
        SimpleDateFormat fmt = new SimpleDateFormat(format); //创建要显示的日期格式
        //注意了，这里的   MM 在java中代表月份，而  mm 代表分钟， HH 代表24小时制的时间， hh 代表12小时制的时间,很严格的
        Date date = fmt.parse(dateTime);      //将从数据库读出来的 timestamp 类型的时间转换为java的Date类型
        String s = fmt.format(date);
        return s;
    }

    public static  String addDay(String date,Integer dayNum,String format) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        Date dt=sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.DATE,dayNum);
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 获取时间差
     * @param firstTime
     * @param endTime
     * @return
     * @throws Exception
     */
    public static String getTimeDiff(String firstTime,String endTime) throws Exception{
        if(firstTime.trim().isEmpty()||endTime.trim().isEmpty()){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = sdf.parse(firstTime);
        Date date2 = sdf.parse(endTime);
        long l = date2.getTime() - date1.getTime();
        long day = l / (24 * 60 * 60 * 1000);
        long hour = (l / (60 * 60 * 1000) - day * 24);
        long min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (l / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        return day + "天" + hour + "小时" + min +"分" + s + "秒";
    }

    public static String getNowTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String s = df.format(new Date());// new Date()为获取当前系统时间
        return s;
    }

    /**
     * 获取时间差
     * @param type  1天数2小时数3分钟数
     * @param startTime
     * @param endTime
     * @return
     */
    public static int getTimesDiff(int type, String startTime, String endTime) {
        if (!StringUtils.isEmpty(startTime) && !StringUtils.isEmpty(endTime)) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                long from = sdf.parse(startTime).getTime();
                long to = sdf.parse(endTime).getTime();
                int times = 0;
                if (type == 1) {
                    times = (int) ((to - from)/(1000 * 60 * 60 * 24));
                } else if (type == 2) {
                    times = (int) ((to - from)/(1000 * 60 * 60));
                } else if (type == 3) {
                    times = (int) ((to - from)/(1000 * 60));
                }
                return times;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    private static final DateTimeFormatter fmt_1 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

    public static Date parse(String source){
        DateTime d = fmt_1.parseDateTime(source);
        return d.toDate();
    }

    public static String toString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    public static String toString_2(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    public static Integer toString_3(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        return Integer.valueOf(formatter.format(date));
    }


    /**
     * 统一返回日期格式
     *
     * @return 2017-09-23 00:00:00
     */
    @SuppressWarnings("finally")
    public static String formatDate(String dateStr) {
        HashMap<String, String> dateRegFormat = new HashMap<String, String>();
        dateRegFormat.put("^\\d{4}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D+\\d{1,2}\\D*$", "yyyy-MM-dd-HH-mm-ss");//2014年3月12日 13时5分34秒，2014-03-12 12:05:34，2014/3/12 12:5:34
        dateRegFormat.put("^\\d{4}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}$", "yyyy-MM-dd-HH-mm");//2014-03-12 12:05
        dateRegFormat.put("^\\d{4}\\D+\\d{2}\\D+\\d{2}\\D+\\d{2}$", "yyyy-MM-dd-HH");//2014-03-12 12
        dateRegFormat.put("^\\d{4}\\D+\\d{2}\\D+\\d{2}$", "yyyy-MM-dd");//2014-03-12
        dateRegFormat.put("^\\d{4}\\D+\\d{2}$", "yyyy-MM");//2014-03
        dateRegFormat.put("^\\d{4}$", "yyyy");//2014
        dateRegFormat.put("^\\d{14}$", "yyyyMMddHHmmss");//20140312120534
        dateRegFormat.put("^\\d{12}$", "yyyyMMddHHmm");//201403121205
        dateRegFormat.put("^\\d{10}$", "yyyyMMddHH");//2014031212
        dateRegFormat.put("^\\d{8}$", "yyyyMMdd");//20140312
        dateRegFormat.put("^\\d{6}$", "yyyyMM");//201403
        dateRegFormat.put("^\\d{2}\\s*:\\s*\\d{2}\\s*:\\s*\\d{2}$", "yyyy-MM-dd-HH-mm-ss");//13:05:34  拼接当前日期
        dateRegFormat.put("^\\d{2}\\s*:\\s*\\d{2}$", "yyyy-MM-dd-HH-mm");//13:05  拼接当前日期
        dateRegFormat.put("^\\d{2}\\D+\\d{1,2}\\D+\\d{1,2}$", "yy-MM-dd");//14.10.18(年.月.日)
        dateRegFormat.put("^\\d{1,2}\\D+\\d{1,2}$", "yyyy-dd-MM");//30.12(日.月) 拼接当前年份
        dateRegFormat.put("^\\d{1,2}\\D+\\d{1,2}\\D+\\d{4}$", "dd-MM-yyyy");//12.21.2013(日.月.年)

        String curDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        DateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat formatter2;
        String dateReplace;
        String strSuccess = "";
        try {
            for (String key : dateRegFormat.keySet()) {
                if (Pattern.compile(key).matcher(dateStr).matches()) {
                    formatter2 = new SimpleDateFormat(dateRegFormat.get(key));
                    if (key.equals("^\\d{2}\\s*:\\s*\\d{2}\\s*:\\s*\\d{2}$")
                            || key.equals("^\\d{2}\\s*:\\s*\\d{2}$")) {//13:05:34 或 13:05 拼接当前日期
                        dateStr = curDate + "-" + dateStr;
                    } else if (key.equals("^\\d{1,2}\\D+\\d{1,2}$")) {//21.1 (日.月) 拼接当前年份
                        dateStr = curDate.substring(0, 4) + "-" + dateStr;
                    }
                    dateReplace = dateStr.replaceAll("\\D+", "-");
                    // System.out.println(dateRegExpArr[i]);
                    strSuccess = formatter1.format(formatter2.parse(dateReplace));
                    break;
                }
            }
        } catch (Exception e) {
            return "";
        }
        return strSuccess;
    }


    //字符转日期 yyyy-MM-dd HH:mm:ss
//    public static Date StrToDate(String str) throws ParseException {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
//    }

    //日期转字符 yyyy-MM-dd HH:mm:ss
    public static String DateToStr(Date date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        Integer i = Integer.parseInt(String.valueOf(between_days));
        return i < 0 ? 0 : i;
    }

    /**
     * 将时间戳转换为时间
     */
    public static Date stampToDate(String s) {
        return new Date(new Long(s) * 1000);
    }








}