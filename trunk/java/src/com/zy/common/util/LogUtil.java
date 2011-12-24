package com.zy.common.util;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
	
	public class LogUtil {
	    private static final String LINE_SEP = System.getProperty("line.separator");
	    private static final int LINE_SEP_LEN = LINE_SEP.length();
	    private static final String str = LogUtil.class.getName();

	    private static String getLocationInfo(Throwable t, String fqnOfCallingClass) {

	        StringWriter sw = new StringWriter();
	        PrintWriter pw = new PrintWriter(sw);

	        if (t == null) {
	            return null;
	        }
	        String s;
	        // Protect against multiple access to sw.
	        synchronized (sw) {
	            t.printStackTrace(pw);
	            s = sw.toString();
	            sw.getBuffer().setLength(0);
	        }

	        int ibegin;
	        int iend;

	        // Given the current structure of the package, the line
	        // containing "org.apache.log4j.Category." should be printed just
	        // before the caller.
	        // This method of searching may not be fastest but it's safer
	        // than counting the stack depth which is not guaranteed to be
	        // constant across JVM implementations.
	        ibegin = s.lastIndexOf(fqnOfCallingClass);
	        if (ibegin == -1) {
	            return null;
	        }
	        ibegin = s.indexOf(LINE_SEP, ibegin);
	        if (ibegin == -1) {
	            return null;
	        }
	        ibegin += LINE_SEP_LEN;

	        // determine end of line
	        iend = s.indexOf(LINE_SEP, ibegin);
	        if (iend == -1) {
	            return null;
	        }
	        // VA has a different stack trace format which doesn't
	        // need to skip the inital 'at'
	        if (true) {
	            // back up to first blank character
	            ibegin = s.lastIndexOf("at ", iend);
	            if (ibegin == -1) {
	                return null;
	            }
	            // Add 3 to skip "at ";
	            ibegin += 3;
	        }
	        // everything between is the requested stack item
	        String str1 = s.substring(ibegin, iend);
	        //System.out.println(str);
	        String tempStr = str1.substring(0, str1.lastIndexOf("."));

	        String resultStr = tempStr.substring(0, tempStr.lastIndexOf("."));

	        return resultStr;

	        //System.out.println(resultStr);
	    }

	    private static Logger getLog() {
	       //String className = getLocationInfo(new Exception(), LogUtil.class.getName());
	     //  className = null;
	    	//if (className != null) {
	       //    return Logger.getLogger(className);
	       // } else {
	            return Logger.getLogger(LogUtil.class);
	       // }
	    }
	    
	    public static void debug(Object obj) {
	        debug(obj, null);
	    }

	    public static void debug(Object obj, Throwable throwable) {
	        getLog().log(str, Level.DEBUG, obj, throwable);
	    }
	    
	    public static void info(Object obj) {
	        info(obj, null);
	    }

	    public static void info(Object obj, Throwable throwable) {
	        getLog().log(str, Level.INFO, obj, throwable);
	    }

	    public static void warn(Object obj) {
	        warn(obj, null);
	    }

	    public static void warn(Object obj, Throwable throwable) {
	        getLog().log(str, Level.WARN, obj, throwable);
	    }

	    public static void error(Object obj) {
	        error(obj, null);
	    }

	    public static void error(Object obj, Throwable throwable) {
	        getLog().log(str, Level.ERROR, obj, throwable);
	    }

	    public static void fatal(Object obj) {
	        fatal(obj, null);
	    }

	    public static void fatal(Object obj, Throwable throwable) {
	        getLog().log(str, Level.FATAL, obj, throwable);
	    }

	    public static boolean isDebugEnabled() {
	        return getLog().isEnabledFor(Level.DEBUG);
	    }

	    public static boolean isErrorEnabled() {
	        return getLog().isEnabledFor(Level.ERROR);
	    }

	    public static boolean isFatalEnabled() {
	        return getLog().isEnabledFor(Level.FATAL);
	    }

	    public static boolean isInfoEnabled() {
	        return getLog().isEnabledFor(Level.INFO);
	    }

	    public static boolean isTraceEnabled() {
	        return getLog().isEnabledFor(Level.DEBUG);
	    }

	    public static boolean isWarnEnabled() {
	        return getLog().isEnabledFor(Level.WARN);
	    }

	    public static void trace(Object obj) {
	        trace(obj, null);
	    }

	    public static void trace(Object obj, Throwable throwable) {
	        getLog().log(str, Level.DEBUG, obj, throwable);
	    }
	    
	    public static void main(String[] args){
	        System.out.println("test");
	        LogUtil.debug("begin to test");
	    }
}
