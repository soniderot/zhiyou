package com.zy.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class CommonUtil {
	public static ThreadLocal<Boolean> updateGroupVo = new ThreadLocal<Boolean>();
	public static boolean isEmail(String strEmail) {
		if(StringUtils.isBlank(strEmail))
			return false;
		String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";  
		Pattern   p   =   Pattern.compile(regex);  
		Matcher   m   =   p.matcher(strEmail);  
		return m.find();  
	}
	
	public static String removeHTMLTags(String htmlString) {
	    return htmlString.replaceAll("<.+?>", "");
	}
	
	public static void main(String[] args){
		System.out.println(CommonUtil.isEmail("123a1sina.com"));
	}
}
