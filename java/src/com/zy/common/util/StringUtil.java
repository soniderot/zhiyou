package com.zy.common.util;

import java.util.UUID;

public class StringUtil {
	public static String getUUID(){
		return  UUID.randomUUID().toString();
	}
	
	public static boolean isNull(String s) {
		if (s == null || s.equals("")) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}

}
