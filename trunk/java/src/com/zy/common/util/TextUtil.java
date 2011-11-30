package com.zy.common.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import com.opensymphony.xwork2.util.LocalizedTextUtil;

/**
 * 
 * @author Bing
 *
 * 2010-1-6 下午03:10:47

 * @Description:
 */
public class TextUtil {
	
	public static String getText(String key,String language,String country){
		Locale locale = new Locale(language,country);
		return getText(key,locale);
	}
	
	public static String getText(String key,Locale locale){
		String value="";
		ResourceBundle bundle = LocalizedTextUtil.findResourceBundle("messageResource", locale);
		value=bundle.getString(key);
		return value;
	}
	
	public static String getText(String key,String locale){
    	ResourceBundle bundle = LocalizedTextUtil.findResourceBundle("messageResource", Locale.CHINA);
		return bundle.getString(key);
    }
	
	public static String getText(String key){
    	ResourceBundle bundle =	LocalizedTextUtil.findResourceBundle("messageResource", Locale.CHINA);
		return bundle.getString(key);
    }
	public static String getText(String key,Object [] params)
	{
		String message=getText(key);
		return MessageFormat.format(message, params);
	}
	public static String getText(String key,Object [] params,String locale)
	{
		String message=getText(key,locale);
		return MessageFormat.format(message, params);
	}
	public static String getGenderPron(short gender,String locale){
		if(gender==1){
			return TextUtil.getText("gender_female_pron",locale);
		}
		return TextUtil.getText("gender_male_pron",locale);
	}
	
	public static String getGenderPron(short gender){
		if(gender==1){
			return TextUtil.getText("gender_female_pron");
		}
		return TextUtil.getText("gender_male_pron");
	}
	
	public static void main(String [] args){
//		String   language   =   System.getProperty("user.language");
//		String   country     =   System.getProperty("user.country");
//		System.out.println("语言"+language+"国家"+country);   
//		System.out.println(Locale.getDefault());
//		System.out.println(TextUtil.getText("common.minute"));
//		System.out.println(TextUtil.getText("group.name", "zh", "CN"));
//		System.out.println(TextUtil.getText("site.email.sender", "en", "US"));
//		System.out.println(TextUtil.getText("group.eventinviteByOutLinkConfirm",new String[]{"xx","oo"}));
//		System.out.println(TextUtil.getText("group.createapply.email.unsuccess.tips",new String[]{"f","x"}));
		System.out.println(TextUtil.getText("common.locale.zh_cn"));
	}
	
}
