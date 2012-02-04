package com.zy.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.zy.Constants;

public class DateUtil {
	public static final String patternDate = "yyyy-MM-dd";
	public static final String patternDateTime = "yyyy-MM-dd HH:mm:ss";
	public static final String patternDateTimeCompact = "yyyyMMddHHmmss";
	public static final String patternDateTimeCompact1 = "yyyyMMddHHmmsss";
	public static final String patternMonthday = "MM-dd";
	public static final String lucenedate="yyyyMMdd";
	private static final DateFormat PSUEDO_ISO8601_DATETIME_FORMAT_TZ = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
 
	
	public final static SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
	public static Date BEGIN=null;
	public static Date END=null;

	public static Date getDateTimeByString(String dtstring){
		return getDate(dtstring,patternDateTime);
	}
	
	public static Date getDateByString(String dtstring){
		return getDate(dtstring,patternDate);
	}
	
	public static Date getDate(String dtstring,String pattern){
		DateFormat df = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = df.parse(dtstring);
		} catch (Exception e) {
		}
		return d;
	}
	
	public static String formatDate(Date date, String pattern){
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(date);
	}
	
	public static String formatDate(Date date) {
		return format.format(date);
	}

	public static String getPrettyDate(Date date,String reg)
	{
		  long curTime = System.currentTimeMillis();   
		  
	      long diffDay = 0L;   
	      long diffSecond = 0L;
	      String replacement = "";
	      diffSecond = (curTime - date.getTime()) / 1000L;
	      Calendar curDate = new GregorianCalendar();   
	      curDate.setTime(new Date(curTime));   
	      curDate.set(Calendar.HOUR_OF_DAY, 23);   
	      curDate.set(Calendar.MINUTE, 59);   
	      curDate.set(Calendar.SECOND, 59);   
	      curDate.set(Calendar.MILLISECOND, 999);   
	      diffDay = (curDate.getTimeInMillis() - date.getTime()) / 86400000L;
	      String beforesecond=getText("common.beforesecond");
	      String beforeminute=getText("common.beforeminute");
	      String beforehour=getText("common.beforehour");
	      String beforeday=getText("common.beforeday");
	     
	      SimpleDateFormat sf =new SimpleDateFormat("HH:mm");
	      if (diffDay == 0) {   
	        	  if (diffSecond < 60) {   
	        		  if(diffSecond >= 2)
	        		  {
	        			  beforesecond=getText("common.beforeseconds");
	        		  }
	  	            replacement = diffSecond == 0 ? "1"+beforesecond : diffSecond + beforesecond;   
	  	          } else if (diffSecond < 3600) {   
	  	        	if((diffSecond / 60) >= 2)
	        		  {
	  	        		beforeminute=getText("common.beforeminutes");
	        		  }
	  	            replacement = diffSecond / 60 + beforeminute;   
	  	          } else if (diffSecond < 86400) {   
	  	        	if((diffSecond / 3600) >= 2)
	        		  {
	  	        		beforehour=getText("common.beforehours");
	        		  }
	  	            replacement = diffSecond / 3600 + beforehour ;   
	  	          }
	      } 
	      else if (diffDay <= 7) { 
	    	  if(diffDay >= 2)
	    	  {
	    		  beforeday=getText("common.beforedays");
	    	  }
	    	  if("#".equals(reg))
	    	  {
	    		  replacement = diffDay + beforeday+sf.format(date);
	    	  }
	    	  else
	    	  {
	    		  replacement = diffDay + beforeday;
	    	  }
	      }  
	      else 
	      {
	    	  replacement=new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
	      }
	      
	      return replacement;
	}

	public static String getPrettyDate(Date date)
	{
		return getPrettyDate(date,"#");
	}

	/**
	 * Bing
	 * 2009-11-16
	 * calculate the begin date and end date of last week 
	 * example:
	 *      <code>
	 *      String date="2009-10-23 14:33:00";
	 *      Calendar c1 = Calendar.getInstance();
			c1.setTime(sf.parse(date));
			DateUtil.calcLastWeek(c1);
			System.out.println(DateUtil.BEGIN);
			System.out.println(DateUtil.END);
			</code>
	 * @see DateUtil.Begin ,DateUtil.END
	 * @param calendar
	 */
	public   static   void  calcLastWeek(Calendar calendar)
	{
       int  minus = calendar.get(Calendar.DAY_OF_WEEK);
       calendar.add(Calendar.DATE, - minus);
       END = new  java.util.Date(calendar.getTime().getTime());
       calendar.add(Calendar.DATE, - 6 );
       BEGIN = new  java.util.Date(calendar.getTime().getTime());
   } 
	
	/**
	 * 2009-11-27
	 * calculate the begin date and end date of current week which come from the param date
	 * example:
	 *      <code>
	 *      SimpleDateFormat  sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 *      long curTime = System.currentTimeMillis();   
		    Date date2 = new Date(curTime - 3600 * 1000L * 24 * 10);
			DateUtil.calcCurrentWeek(date2);
			System.out.println(sf.format(DateUtil.BEGIN)+"   "+sf.format(DateUtil.END));
			</code>
	 * @param date
	 * @see DateUtil.Begin ,DateUtil.END
	 */
    public static void calcCurrentWeek(Date date)
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar c = Calendar.getInstance();
    	int weekday = c.get(7)-1;
    	c.add(5,-weekday);
    	Date beginday=date;
		try {
			beginday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Date fristDateOfMonth=getFristDateOfMonth(date);
    	if(beginday.before(fristDateOfMonth))
    	{
    		beginday=fristDateOfMonth;
    	}
    	c.add(5,6);
    	Date endday=date;
		try {
			endday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Date lastDateOfMonth=getLastDateOfMonth(date);
    	if(endday.after(lastDateOfMonth))
    	{
    		endday=lastDateOfMonth;
    	}
    	DateUtil.BEGIN=beginday;
    	DateUtil.END=endday;
    }

    public static void calcNextWeek(Date date)
	{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar c = Calendar.getInstance();
    	c.setTime(date);
    	int weekday = c.get(Calendar.DAY_OF_WEEK);
    	c.add(5,8-weekday);
    	Date beginday=date;
		try {
			beginday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Date fristDateOfMonth=getFristDateOfMonth(date);
    	if(beginday.before(fristDateOfMonth))
    	{
    		beginday=fristDateOfMonth;
    	}
    	c.setTime(beginday);
    	Date endday=date;
    	c.add(5,6);
		try {
			endday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Date lastDateOfMonth=getLastDateOfMonth(beginday);
    	if(endday.after(lastDateOfMonth))
    	{
    		endday=lastDateOfMonth;
    	}
    	DateUtil.BEGIN=beginday;
    	DateUtil.END=endday;
	}

    public static boolean inCurrentWeek(Date date)
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Calendar c = Calendar.getInstance();
    	int weekday = c.get(7)-1;
    	c.add(5,-weekday);
    	Date beginday=date;
		try {
			beginday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Date fristDateOfMonth=getFristDateOfMonth(date);
    	if(beginday.before(fristDateOfMonth))
    	{
    		beginday=fristDateOfMonth;
    	}
    	c.add(5,6);
    	Date endday=date;
		try {
			endday = sdf.parse(sdf.format(c.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Date lastDateOfMonth=getLastDateOfMonth(date);
    	if(endday.after(lastDateOfMonth))
    	{
    		endday=lastDateOfMonth;
    	}
		if((beginday.compareTo(date) <= 0 && endday.after(date))
		 ||(endday.compareTo(date) >= 0 && beginday.before(date)))
		{
			return true;
		}
		return false;
    }
 
    public static Date getLastDateOfMonth(Date dt)
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     if (dt == null)
	      return null;
	     Calendar cal = Calendar.getInstance();
	     cal.setTime(dt);
	     int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	     cal.set(Calendar.DAY_OF_MONTH, days);
	     try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    public static Date getLastDateOfWeek(Date dt)
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     if (dt == null)
	      return null;
	     Calendar cal = Calendar.getInstance();
	     cal.setTime(dt);
	     int days = cal.getActualMaximum(Calendar.DAY_OF_WEEK);
	     cal.set(Calendar.DAY_OF_WEEK, days);
	     try {
			return sdf.parse(sdf.format(cal.getTime()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    public static Date getFristDateOfMonth(Date dt)
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     if (dt == null)
	      return null;
	     Calendar cal = Calendar.getInstance();
	     cal.setTime(dt);
	     int days = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
	     cal.set(Calendar.DAY_OF_MONTH, days);
	     try {
				return sdf.parse(sdf.format(cal.getTime()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
    }

    private static String getText(String key)
    {
    	
    	return TextUtil.getText(key);
    }
    /**
     * recent days 
     * @param days
     * @return
     */
    public static Date getRecentDate(int days){
    	Calendar cal=Calendar.getInstance();
    	cal.setTime(new Date());
    	Date date=cal.getTime();
    	cal.add(Calendar.DATE, -days);
    	date=cal.getTime();
    	return date;
    }
    
    /**
     * recent days 
     * @param days
     * @return
     */
    public static Date addDate(Date date, int days){
    	Calendar cal=Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.DATE, days);
    	date=cal.getTime();
    	return date;
    }
    
    public static List<String> getCurrentWeek(){
    	List<String> list = new ArrayList<String>();
    	Calendar calendar = Calendar.getInstance();
    	list.add(format.format(calendar.getTime()));
    	calendar.add(Calendar.DAY_OF_MONTH, -7);
    	list.add(0, format.format(calendar.getTime()));
    	
    	return list;
    }
    
    
    public static void main11(String []args){
    	
    }
    
    public static int getDayOfWeek()
    {
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int  day = calendar.get(Calendar.DAY_OF_WEEK);
		return day;
    }
    public static int getDayOfWeek(String date)
    {
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateUtil.getDateByString(date));
		int  day = calendar.get(Calendar.DAY_OF_WEEK);
		return day;
    }
 
    public static int findTotalMonth(Integer startYear, Short startMonth, Integer endYear, Short endMonth) {
        if (endYear == null || endYear == 9999) {
            Calendar c = Calendar.getInstance();
            endYear = c.get(Calendar.YEAR);
            endMonth = (short)c.get(Calendar.MONTH);
        }
        int yearSpan = endYear - startYear;
        int monthSpan = endMonth - startMonth;
        if (yearSpan < 0) {
            return 0;
        }
        int months = yearSpan * 12 + monthSpan;
        return months;
    }
  
    
	//ISO8601
	 public static String toIso8601DateTime(Date dateTime) {
        if(dateTime == null) return null;
        Calendar c = Calendar.getInstance();
        c.setTime(dateTime);
        c.add(Calendar.HOUR_OF_DAY, -8);
        dateTime=c.getTime();
        String iso8601DateTime=PSUEDO_ISO8601_DATETIME_FORMAT_TZ.format(dateTime);
        return iso8601DateTime;
    }
	 
	
	 public static int computeAge(Date date) {
	        if (date == null) {
	            return 0;
	        }
	        Calendar currentDate = new GregorianCalendar();
	        Calendar birthDate = new GregorianCalendar();
	        birthDate.setTime(date);
	        Calendar testDate = new GregorianCalendar();
	        testDate.setTime(date);
	        int approximateAge = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);
	        testDate.add(Calendar.YEAR, approximateAge);
	        return (testDate.after(currentDate)) ? approximateAge - 1 : approximateAge;
	 }

	 public static Date computeBirthDate(int age) {
	        Calendar cal = new GregorianCalendar();
	        cal.add(Calendar.YEAR, -age);
	        normalizeCalendar(cal);
	        return cal.getTime();
	 }
     
	 private static void normalizeCalendar(Calendar cal) {
	        if (cal == null) {
	            return;
	        }
	        cal.clear(Calendar.HOUR);
	        cal.clear(Calendar.HOUR_OF_DAY);
	        cal.clear(Calendar.MINUTE);
	        cal.clear(Calendar.SECOND);
	        cal.clear(Calendar.MILLISECOND);
	  }
	 
	 public static void main(String[] args){
		 DateFormat df = new SimpleDateFormat("yyyyMMdd");
		 System.out.println(df.format(DateUtil.computeBirthDate(25)));
		 System.out.println(DateUtil.computeBirthDate(25));
	 }
}
