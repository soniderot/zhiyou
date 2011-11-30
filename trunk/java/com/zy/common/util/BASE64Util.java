package com.zy.common.util;

import sun.misc.BASE64Decoder;

public class BASE64Util {
	public static String encode(String s) {
		if (s == null) {
			return null;
		} else {
			String tempStr = (new sun.misc.BASE64Encoder()).encode(s.getBytes());
			tempStr = tempStr.replaceAll("\n", "");
			tempStr = tempStr.replaceAll("\r", "");
			return tempStr;
		}
	}

	public static String decode(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			LogUtil.error(e);
			return null;
		}
	}
	public static void main(String [] args)
	{
		System.out.println(BASE64Util.encode("liubingwwww@163.com"));
	}
}
