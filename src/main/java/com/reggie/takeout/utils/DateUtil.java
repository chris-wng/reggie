package com.reggie.takeout.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {


    /** The Constant yyyy_MM_dd_HH_mm_ss. */
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";

    /** The Constant yyyy_MM_dd_HH_mm. */
    public static final String yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";

    /** The Constant yyyy_MM_dd. */
    public static final String yyyy_MM_dd = "yyyy-MM-dd";

    /** The Constant yyyy_MM. */
    public static final String yyyy_MM = "yyyy-MM";

    /** The Constant MM_DD. */
    public static final String MM_DD = "MM-dd";

    /** The Constant yyyy. */
    public static final String yyyy = "yyyy";

    /** The Constant MM. */
    public static final String MM = "MM";

    /** The Constant dd. */
    public static final String dd = "dd";

    /** The Constant HH_mm_ss. */
    public static final String HH_mm_ss = "HH:mm:ss";

    /** The Constant HH_mm. */
    public static final String HH_mm = "HH:mm";

    /** The Constant mm_ss. */
    public static final String mm_ss = "mm:ss";

    /** The Constant yyyyMMddHHmmssS. */
    public static final String yyyyMMddHHmmssS = "yyyyMMddHHmmssS";

    /** The Constant yyyyMMddHHmmss. */
    public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";

    /** The Constant yyMMddHHmmss. */
    public static final String yyMMddHHmmss = "yyMMddHHmmss";

    /** The Constant yyyyMMdd. */
    public static final String yyyyMMdd = "yyyyMMdd";

    /** The Constant yyyyMM. */
    public static final String yyyyMM= "yyyyMM";

    /** The Constant MMddHHmmssS. */
    public static final String MMddHHmmssS = "MMddHHmmssS";

    /** The Constant MMddHHmmss. */
    public static final String MMddHHmmss = "MMddHHmmss";

    /** The Constant HHmmssS. */
    public static final String HHmmssS = "HHmmssS";

    /** The Constant HHmmss. */
    public static final String HHmmss = "HHmmss";


    /**
     * ????????????????????????????????????.
     *
     * @param date the date
     * @param format the format
     * @return the string
     */
    public static String date2String(Date date, String format) {
        if (date == null) {
            date = new Date();
        }
        String dateStr = null;
        if (date != null) {
            dateStr = new SimpleDateFormat(format).format(date);
        }
        return dateStr;
    }

    /**
     * ??????????????????????????????.
     *
     * @param dateStr the date str
     * @param format the format
     * @return the date
     * @throws ParseException the parse exception
     */
    public static Date string2Date(String dateStr, String format) throws ParseException {
        Date date = null;
        date = new SimpleDateFormat(format).parse(dateStr);
        return date;
    }

    /**
     * ???????????????????????????????????????????????????.
     *
     * @param dateStr the date str
     * @param oldFormat the old format
     * @param newFormat the new format
     * @return the string
     * @throws ParseException the parse exception
     */
    public static String convertDateString(String dateStr, String oldFormat, String newFormat) throws ParseException {
        Date date = null;
        date = new SimpleDateFormat(oldFormat).parse(dateStr);

        String outDateStr = new SimpleDateFormat(newFormat).format(date);
        return outDateStr;
    }


    /**
     * ?????????????????? ??????????????????.
     *
     * @param format the format
     * @return the now
     */
    public static String getNow(String format) {
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * ????????????.
     *
     * @param addDay the add day
     * @param format the format
     * @return the string
     */
    public static String operateDate(int addDay, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + addDay); //????????????1
        Date time = calendar.getTime();
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    /**
     * ???????????????n???
     * @param addDay
     * @param format
     * @return
     */
    public static String operateDateAdd(int addDay,Date date, String format) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + addDay); //????????????1
        Date time = calendar.getTime();
        return new SimpleDateFormat(format).format(calendar.getTime());
    }

    /**
     *
     * ???????????????????????????????????????  .
     *
     * @param smdate ???????????????
     * @param bdate  ???????????????
     * @return ????????????
     * @throws ParseException the parse exception
     */
    public static int daysBetween(Date smdate,Date bdate) throws ParseException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     *
     * ???????????????????????????????????????  .
     *
     * @return ????????????
     * @throws ParseException the parse exception
     */
    public static int secondBetween(Date startDate,Date endDate) throws ParseException
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000);

        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     * ??????30???????????????.
     *
     * @param format the format
     * @return the last month
     */
    public static String getLastMonth(String format){
        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        cl.add(Calendar.MONTH, -1);
        return new SimpleDateFormat(format).format(cl.getTime());
    }

    /**
     * ?????????????????????.
     *
     * @param format the format
     * @return the last half year
     */
    public static String getLastHalfYear(String format){
        Calendar cl = Calendar.getInstance();
        cl.setTime(new Date());
        cl.add(Calendar.MONTH, -6);
        return new SimpleDateFormat(format).format(cl.getTime());
    }

    /**
     * ????????????????????????.
     *
     * @return the last week date
     */
    public static String getLastWeekDate() {
        Format f = new SimpleDateFormat(yyyy_MM_dd);
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int lastSunday = 7 - dayOfWeek + 1;
        c.set(Calendar.DAY_OF_MONTH, -lastSunday);
        return f.format(c.getTime());
    }


    /**
     * Gets the year.
     *
     * @param date the date
     * @return the year
     */
    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }


    /**
     * Gets the month.
     *
     * @param date the date
     * @return the month
     */
    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    //??????????????????????????????
    public static String getPastMonthDate(int i) {
        SimpleDateFormat sdf = new SimpleDateFormat(yyyy_MM_dd_HH_mm_ss);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -i);
        return sdf.format(calendar.getTime());
    }

    /**
     * Gets the day.
     *
     * @param date the date
     * @return the day
     */
    public static int getDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }

    /**
     * ??????????????????.
     *
     * @return the current year
     */
    public static int getCurrentYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * ??????????????????.
     *
     * @return the current month
     */
    public static int getCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * ??????????????????.
     *
     * @return the current day
     */
    public static int getCurrentDay() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DATE);
    }

    /**
     * ??????????????????.
     *
     * @return the curren hour
     */
    public static int getCurrenHour() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * ??????????????????.
     *
     * @return the curren minute
     */
    public static int getCurrenMinute() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MINUTE);
    }

    /**
     * ???????????????.
     *
     * @return the curren second
     */
    public static int getCurrenSecond() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.SECOND);
    }

    /**
     * ???????????????????????????.
     *
     * @return the curren week of year
     */
    public static int getCurrenWeekOfYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * ???????????????????????????.
     *
     * @return the curren week of month
     */
    public static int getCurrenWeekOfMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * ???????????????????????????.
     *
     * @return the curren day of year
     */
    public static int getCurrenDayOfYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * ??????????????????????????????.
     *
     * @return the day of month
     */
    public static int getDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * ??????????????????????????????.
     *
     * @param str the str
     * @return the day of month
     * @throws ParseException the parse exception
     */
    public static int getDayOfMonth(String str) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(string2Date(str, yyyy_MM));
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * ????????????30??? ????????????.
     *
     * @param format the format
     * @return the last month list
     */
    public static List<String> getLastMonthList(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Long currentTimeMillis = System.currentTimeMillis();
        String endDate = sdf.format(new Date(currentTimeMillis));
        String startDate = sdf.format(currentTimeMillis - 30 * 24 * 3600 * 1000L);

        List<String> al = new ArrayList<String>();

        SimpleDateFormat sdf2 = new SimpleDateFormat(yyyyMMdd);
        String endDate2 = sdf2.format(new Date(currentTimeMillis));
        String startDate2 = sdf2.format(currentTimeMillis - 30 * 24 * 3600 * 1000L);

        while (startDate2.compareTo(endDate2) < 1) {
            al.add(startDate);
            try {
                Long l = sdf.parse(startDate).getTime();
                startDate = sdf.format(l + 24 * 3600 * 1000L); // +1???

                Long l2 = sdf2.parse(startDate2).getTime();
                startDate2 = sdf2.format(l2 + 24 * 3600 * 1000L); // +1???
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return al;
    }

    /**
     * ???????????????????????????????????????????????????
     * @param date
     * @param
     * @return
     */
    public static Map getWeekDate(Date date){
        Map<String,Object> map = new HashMap();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd"); //??????????????????
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//?????????????????????????????????????????????
        if(1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);//???????????????????????????????????????????????????????????????????????????????????????
        int day = cal.get(Calendar.DAY_OF_WEEK);//?????????????????????????????????????????????
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek()-day);//???????????????????????????????????????????????????????????????????????????????????????
        String weekhand = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 6);
        String weeklast = sdf.format(cal.getTime());
        map.put("weekhand",weekhand);
        map.put("weeklast",weeklast);
        return map;
    }
    /**
     * ????????????????????????
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMinMonthDate(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(yyyyMMdd);
        calendar.setTime(dateFormat.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }
    /**
     * ????????????????????????
     * @param date
     * @return
     * @throws ParseException
     */
    public static String getMaxMonthDate(String date) throws ParseException{
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(yyyyMMdd);
        calendar.setTime(dateFormat.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return dateFormat.format(calendar.getTime());
    }
    /**
     * ???????????????????????????????????????????????????????????????
     * @param date
     * @param
     * @return
     */
    public static Map getMonthDate(Date date) {
        Map<String,Object> map = new HashMap();
        if(date!=null){
            try {
                SimpleDateFormat simdf = new SimpleDateFormat(yyyyMMdd);
                Calendar cal = Calendar.getInstance();
                String s = simdf.format(date);
                String maxMonthDate = getMaxMonthDate(s);
                String minMonthDate = getMinMonthDate(s);
                map.put("now",simdf.format(new Date()));
                map.put("minMonthDate",minMonthDate);
                map.put("maxMonthDate",maxMonthDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public static boolean compareDate(Date startDate,Date endDate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH:mm",Locale.CHINA);
        String start = sdf.format(startDate);
        String end = sdf.format(endDate);
        if(start.equals(end)){
            return true;
        }
        return  false;
    }
    /**
     * ?????????????????????????????????true
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareDateYMDH(Date startDate,Date endDate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd HH",Locale.CHINA);
        String start = sdf.format(startDate);
        String end = sdf.format(endDate);
        int to = start.compareTo(end);
        if(to<0){//??????????????????????????????
            return true;
        }
        return false;
    }

    /**
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean belongDateYMD(String define,String startDate,String endDate){
        int b1 = define.compareTo(startDate);
        int b2 = endDate.compareTo(define);
        if(b1<0||b2<0){
            return false;
        }
        return true;
    }

    /**
     * ?????????????????????????????????YYYMMDD
     * @param startDate
     * @param endDate
     * @return
     */
    public static boolean compareDateYMD(Date startDate,Date endDate){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd",Locale.CHINA);
        String start = sdf.format(startDate);
        String end = sdf.format(endDate);
        if(start.equals(end)){
            return true;
        }
        return  false;
    }

    public static boolean compareTimeByHM(String start,String end,String between){
        Date date1 = new Date("2019/10/10 " + start +":00");
        Date date2 = new Date("2019/10/10 " + end +":00");
        Date date3 = new Date("2019/10/10 " + between +":00");
        return date3.after(date1) && date3.before(date2);
    }

    public static void main(String[] args) throws ParseException {
        String now = "2019-11-10 11:00:00";

        boolean b = isValidDateHMS(now);
        System.out.println(b);
    }

    /**
     * ?????????????????????????????????
     *
     * @param start ????????????
     * @param end   ????????????
     * @return ????????????
     */
    public static List<String> getBetweenDates(Date start, Date end) {
        List<String> result = new ArrayList<String>();
        Calendar tempStart = Calendar.getInstance();
        tempStart.setTime(start);
        tempStart.add(Calendar.DAY_OF_YEAR, 1);

        Calendar tempEnd = Calendar.getInstance();
        tempEnd.setTime(end);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (tempStart.before(tempEnd)) {
            result.add(format.format(tempStart.getTime()));
            tempStart.add(Calendar.DAY_OF_YEAR, 1);
        }
        return result;
    }

    /**
     * ?????????????????????????????? eg :???2019-01?????????( 2019-01-01 ???2019-01-02,2019-01-03 ...???
     * ?????? year ?????? month ??? ??? maxDate ??????????????????
     */
    public static List<String> transformDate(int year, int month, int maxDate) {
        List<String> dateList = new ArrayList<>();
        String syear = String.valueOf(year);
        String smonth;
        if (month < 10) {
            smonth = "0" + month;
        } else {
            smonth = String.valueOf(month);
        }

        //??????????????????????????????
        for (int i = 1; i <= maxDate; i++) {
            if (i < 10) {
                String date = syear + "-" + smonth + "-" + "0" + i;
                dateList.add(date);
            } else {
                String date = syear + "-" + smonth + "-" + i;
                dateList.add(date);
            }

        }
        return dateList;
    }
    //???????????????????????????
    public static int getDaysByYearMonth(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }
    //???????????? ???past ????????????
    public static Date getFutureDate(int future) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + future);
        Date futureDate = calendar.getTime();
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);*/
        return futureDate;
    }


    //???????????? ???past ????????????
    public static Date getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date pastDate = calendar.getTime();
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String result = format.format(today);*/
        return pastDate;
    }
    //???????????? ???past ????????????????????????(00:00:00)
    public static Date getPastDateTime(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date pastDate = calendar.getTime();
        return pastDate;
    }

    //???????????? ???past ????????????????????????(23:59:59)
    public static Date getPastDateTimeEnd(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date pastDate = calendar.getTime();
        return pastDate;
    }

    /**
     * Description: ????????????????????????????????????????????? </br>
     *
     * @param nowTime ???????????? </br>
     * @param beginTime ???????????? </br>
     * @param endTime ???????????? </br>
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }


    /**
     * .Description://?????????????????????????????????
     * .Author:
     * .@Date: 2019???8???12???09:21:35
     */
    public static String getWeek(String dateTime){
        String week = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(dateTime);
            SimpleDateFormat dateFm = new SimpleDateFormat("EEEE",Locale.CHINA);
            week = dateFm.format(date);
            week=week.replaceAll("??????","???");
        }catch (ParseException e){
            e.printStackTrace();
        }
        return week;
    }

    /**
     * ????????????????????????????????????
     * @param intervals      intervals??????
     * @return              ????????????
     * @throws ParseException
     */
    public static ArrayList<String> getDays(String searchDate,int intervals) throws ParseException {
        ArrayList<String> pastDaysList = new ArrayList<>();
        for (int i =0 ; i < intervals; i++) {
            pastDaysList.add(getPastDate(searchDate,i));
        }
        return pastDaysList;
    }
    /**
     * ??????????????????????????????
     * @param past
     * @return
     * @throws ParseException
     */
    public static String getPastDate(String searchDate,int past) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date=format.parse(searchDate);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + past);
        Date today = calendar.getTime();
        String result = format.format(today);
        return result;
    }

    /**
     * ??????????????????????????????????????????
     * @param date1
     * @param date2
     * @param pattern
     * @return
     */
    public static boolean compareDateByFormat(String date1,String date2,String pattern){
        boolean flag = true;
        DateFormat dateFormat=new SimpleDateFormat(pattern);
        try {
            Date d1 = dateFormat.parse(date1);
            Date d2 = dateFormat.parse(date2);
            if(d1.after(d2)){ //d1>d2
                flag = false;
            }else{//d1<=d2
                flag = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * date2???date1????????????
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2){
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2){//?????????
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0){//??????
                    timeDistance += 366;
                }else{//????????????
                    timeDistance += 365;
                }
            }
            int i = timeDistance + (day2 - day1);
            int abs = Math.abs(i);
            return abs;
        }else{//?????????
            System.out.println("??????day2 - day1 : " + (day2-day1));
            int i = day2 - day1;
            int abs = Math.abs(i);
            return abs;
        }
    }
    /**
     * ?????????????????????????????????????????????????????????????????? ???????????????
     * @param startTime MM-dd
     * @param endTime  MM-dd
     * @return
     */
    public static List<String> getDateTimeList(String startTime, String endTime){
        // ?????????????????????
        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        List<String> dateListMMdd = new ArrayList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat MMDD = new SimpleDateFormat("MM-dd");
        try{
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
//            tempEnd.add(Calendar.DATE, +1);// ?????????1(????????????)
            while (tempStart.before(tempEnd)) {
                dateListMMdd.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        }catch(ParseException e){
            e.printStackTrace();
        }
        return dateListMMdd;
    }

    /**
     * ?????????????????????????????????????????????
     * @param dateFrom ????????????
     * @param dateEnd ????????????
     * @param weekDays ??????
     * @return ??????????????????
     */
    public static String[] getDates(String dateFrom, String dateEnd, String weekDays) {
        long time = 1l;
        long perDayMilSec = 24 * 60 * 60 * 1000;
        List<String> dateList = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //???????????????????????????
        String strWeekNumber = weekForNum(weekDays);
        try {
            dateFrom = sdf.format(sdf.parse(dateFrom).getTime() - perDayMilSec);
            while (true) {
                time = sdf.parse(dateFrom).getTime();
                time = time + perDayMilSec;
                Date date = new Date(time);
                dateFrom = sdf.format(date);
                if (dateFrom.compareTo(dateEnd) <= 0) {
                    //????????????????????????????????????
                    Integer weekDay = dayForWeek(date);
                    //?????????????????????????????????????????????????????????
                    if (strWeekNumber.indexOf(weekDay.toString())!=-1) {
                        System.out.println(dateFrom);
                        dateList.add(dateFrom);
                    }
                } else {
                    break;
                }
            }
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        String[] dateArray = new String[dateList.size()];
        dateList.toArray(dateArray);
        return dateArray;
    }

    //?????????????????????????????????????????????1???????????????2???????????????3???????????????4???????????????5???????????????6???????????????7
    public static Integer dayForWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * ???????????????????????????  ????????????1???????????????2???????????????3???????????????4???????????????5???????????????6???????????????7
     * @param weekDays ????????????  ?????????|?????????
     */
    public static String weekForNum(String weekDays){
        //????????????????????????????????????
        String weekNumber = "";
        //?????????????????????
        if(weekDays.indexOf("|")!=-1){//???????????????
            String []strWeeks = weekDays.split("\\|");
            for(int i=0;i<strWeeks.length;i++){
                weekNumber = weekNumber + "" + getWeekNum(strWeeks[i]).toString();
            }
        }else{//???????????????
            weekNumber = getWeekNum(weekDays).toString();
        }

        return weekNumber;

    }

    //?????????????????????????????????  ????????????1???????????????2???????????????3???????????????4???????????????5???????????????6???????????????7
    public static Integer getWeekNum(String strWeek){
        Integer number = 1;//??????????????????
        if("??????".equals(strWeek)){
            number = 1;
        }else if("??????".equals(strWeek)){
            number = 2;
        }else if("??????".equals(strWeek)){
            number = 3;
        }else if("??????".equals(strWeek)){
            number = 4;
        }else if("??????".equals(strWeek)){
            number = 5;
        }else if("??????".equals(strWeek)){
            number = 6;
        }else if("??????".equals(strWeek)){
            number = 7;
        }
        return number;
    }

    public static List<String> getDateList(String startTime, String endTime){
        // ?????????????????????
        Calendar calendar = Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        List<String> dateListMMdd = new ArrayList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date start = dateFormat.parse(startTime);
            Date end = dateFormat.parse(endTime);
            Calendar tempStart = Calendar.getInstance();
            tempStart.setTime(start);
            Calendar tempEnd = Calendar.getInstance();
            tempEnd.setTime(end);
            while (tempStart.before(tempEnd)) {
                dateListMMdd.add(dateFormat.format(tempStart.getTime()));
                tempStart.add(Calendar.DAY_OF_YEAR, 1);
            }
        }catch(ParseException e){
            e.printStackTrace();
        }
        return dateListMMdd;
    }

    /**
     * ???????????????????????????????????????
     * @param str
     * @return
     */
    public static boolean isValidDateHMS(String str) {
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.yyyy_MM_dd_HH_mm_ss);
        try {
            // ??????lenient???false.
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // ??????throw java.text.ParseException??????NullPointerException????????????????????????
            convertSuccess = false;
        }
        if(DateUtil.yyyy_MM_dd_HH_mm_ss.length()!=str.length()){
            convertSuccess = false;
        }else{
            String substring = str.substring(11, str.length());
            String[] split = substring.split(":");
            if(split.length!=3||!split[1].equals("00")||!split[2].equals("00")||Integer.parseInt(split[0])>24){
                convertSuccess = false;
            }
        }
        return convertSuccess;
    }

    /**
     * ????????????????????????????????????
     * @author liuzhong3
     * */
    public static boolean isTheSameDay(Date d1,Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);
        return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
                && (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
                && (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * ????????????????????????
     * @return
     */
    public static String getStartDateOfThisMonth() {
        SimpleDateFormat format = new SimpleDateFormat(yyyy_MM_dd);
        Calendar cale = Calendar.getInstance();
        // ???????????????????????????
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        String firstday = format.format(cale.getTime());
        return firstday;
    }

    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.yyyy_MM_dd);
        try {
            // ??????lenient???false.
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // ??????throw java.text.ParseException??????NullPointerException????????????????????????
            convertSuccess = false;
        }
        if(DateUtil.yyyy_MM_dd.length()!=str.length()){
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**
     * ??????????????????  ??????????????????????????????
     */
    public static String formatDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateStr);
        return sdf.format(new Date());
    }

    public static Date stringToDate(String strTime, String formatType) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    /**
     * ???????????? ????????????????????? ?????????
     */
    public static String getDayOfWeekByDate(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E", Locale.US);
            String str = formatter.format(myDate);
            dayOfweek = str;

        }
        catch (Exception e) {
            System.out.println("??????!");
        }
        return dayOfweek;
    }

    public static long stringToLong(String strTime, String formatType) throws ParseException {
        Date date = stringToDate(strTime, formatType); // String????????????date??????
        long currentTime = dateToLong(date); // date????????????long??????
        return currentTime;
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }


    public static String timestampToString (Long time,String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateStr);
        Timestamp ts = new Timestamp(time);
        return  sdf.format(ts);
    }

}
