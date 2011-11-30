package com.zy.common.util;

import java.io.UnsupportedEncodingException;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;

import org.apache.commons.lang.StringUtils;

import com.zy.Constants;

/**
 * 
 * @author Jiff
 * 
 *         Oct 26, 2009 2:15:59 PM
 * 
 * @Description: Provide the math related caculation, including hex string,
 *               binary string conversion Typically, it will help to do the bit
 *               caculation. For example, in db, the number is 7, the binary
 *               string will be: 0111, which stand for the corresponding
 *               privilege granting.
 * 
 */

public class StringHelper {

	/***
	 * 
	 * 
	 * @param targetItem
	 *            the item to be compared
	 * @param userPrivilege
	 *            , user privilege
	 * @return
	 */
	public static boolean getPrivilege(final int targetItem, int userPrivilege) {

		return ((userPrivilege & targetItem) == targetItem);

	}

	/**
	 * 
	 * @param keys
	 * @param userPrivilage
	 * @return
	 */
	public static String loadPrivileges(int[] keys, int userPrivilege) {
		StringBuffer sb = new StringBuffer();
		for (int key : keys) {
			if (getPrivilege(key, userPrivilege)) {
				sb.append(key).append(",");
			}
		}
		String setting = sb.toString();
		if (StringUtils.isNotBlank(setting) && setting.length() > 0) {
			return setting.substring(0, setting.lastIndexOf(","));
		}
		return null;
	}
	public static String getPinyin(String hanzi) {

		StringBuffer pinyin=new StringBuffer();
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

		char[] ca = hanzi.toCharArray();
		for (int i = 0; i < ca.length; i++) {

			try {
				if (ca[i]> 0x4E00 && ca[i]<0x9FA5) {
					String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(ca[i], format);
					if (pinyinArray != null && pinyinArray.length > 0) {
						pinyin.append(pinyinArray[0]);
					}
				}else{
					pinyin.append((ca[i]));
				}
			} catch (Exception e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return pinyin.toString();

	}
	/**
	 * Bing
	 * 2010-06-07
	 * @param str
	 * @return
	 */
	public static String print(String [] str)
	{
		String result="";
		for(int i=0;i<str.length;i++)
		{
			result +=str[i]+",";
		}
		return result.substring(0,result.lastIndexOf(","));
	}
	
	public static String subStringByByte(String str, int len){
		if(len <= 0)
			return null;
		if(str == null || str.length() == 0)
			return null;
		
		
		String r = null;
		try {
			r = splitChinese(Constants.CHINESE_BYTES, str, len);
		} catch(Exception e){
			;
		}
		return r;
	}
	public boolean isChinese(char c)
	{
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c); 

        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS 

                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS 

                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A 

                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION 

                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION 

                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) { 
        	return true;
        } 
        return false;
	}
    private static String splitChinese(int chinese_char_len, String str, int sum) throws Exception   
    {   
        int charset = chinese_char_len; //字符集编码   
        if (charset < 2 || 3 < charset)   
        {   
            throw new Exception("chinese_char_len可选值为2和3,2:Unicode编码,一个汉字占2个字节, 3:UTF-8编码,一个汉字占3个字节");   
        }   
        int index = sum - 1;
        if (null == str || "".equals(str))   
        {   
            return str;   
        }   
        if (index <= 0)   
        {   
            return str;   
        }   
  
        byte[] bt = null;   
        try  
        {   
            if (charset == 2)   
            {   
                bt = str.getBytes();   
            }   
            else  
            {   
                bt = str.getBytes("UTF-8");   
            }   
        }   
        catch (UnsupportedEncodingException e)   
        {   
            ;   
        }   
        if (null == bt)   
        {   
            return str;   
        }   
        if (index > bt.length - 1)   
        {   
            index = bt.length - 1; //防越界   
        }   
  
        //如果当前字节小于0，说明当前截取位置 有可能 将中文字符截断了   
        if (bt[index] < 0)   
        {   
            int jsq = 0;   
            int num = index;   
            while (num >= 0)   
            {   
                if (bt[num] < 0)   
                {   
                    jsq += 1; //计数   
                }   
                else  
                {   
                    break; //循环出口   
                }   
                num -= 1;   
            }   
  
            int m = 0;   
            if (charset == 2)   
            {   
                //Unicode编码   
                m = jsq % 2;   
                index -= m;   
                //这里是重点,去掉半个汉字(有可能是半个), m为0表示无一半汉字,   
                String substrx = new String(bt, 0, index + 1); //当前被截断的中文字符整个不取      
                return substrx;   
            }   
            else  
            {   
                // utf-8 编码   
                m = jsq % 3;   
                index -= m;   
                //这里是重点,去掉半个汉字(有可能是半个), m为0表示无一半汉字,   
                String substrx = null;   
                try  
                {   
                    substrx = new String(bt, 0, index + 1, "UTF-8");   
                }   
                catch (UnsupportedEncodingException e)   
                {   
                    ;   
                } //当前被截断的中文字符整个不取     
                return substrx;   
            }   
        }   
        else  
        {   
            String substrx = null;   
            if (charset == 2)   
            {   
                //Unicode编码   
                substrx = new String(bt, 0, index + 1);   
                return substrx;   
            }   
            else  
            {   
                // utf-8 编码   
                try  
                {   
                    substrx = new String(bt, 0, index + 1, "UTF-8");   
                }   
                catch (UnsupportedEncodingException e)   
                {   
                    ;   
                }   
                return substrx;   
            }   
        }   
    }
	
    public static String changeTitleTypeFromUrl(String titleStr,String urlStrType,String toChangeOurStrType) {   
        try {   
            String temp_p = titleStr;   
            String temp = new String(temp_p.getBytes(urlStrType), toChangeOurStrType);   
            return temp;   
        } catch (Exception e) {   
            return null;   
        }   
    }
    
    public static String getBinaryString(int validKey){
    	StringBuffer result = new StringBuffer();
    	String key = Integer.toBinaryString(validKey);
    	for(int i = 0; i < key.length(); i++){
    		result.append(key.charAt(i));
    		if(i != key.length() - 1){
    			result.append(",");
    		}
    	}
    	return result.toString();
    }
    
	public static void main(String [] args)
	{
//		System.out.println(getPinyin("cc刘ff冰xx"));
//		System.out.println(loadPrivileges(new int[]{16384, 32768}, 65535));
		System.out.println(getBinaryString(6));
	}
}
