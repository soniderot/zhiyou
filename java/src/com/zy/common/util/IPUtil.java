package com.zy.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {

	/**
	 * 获取ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 将ip由字符新型转成long型
	 * 
	 * @param ip
	 * @return
	 */
	public static long getLongValue(String ip) {
		long l = 0;
		long x1 = 256 * 256 * 256;
		long x2 = 256 * 256;
		long x3 = 256;
		String arr[] = ip.split("\\.");
		if (arr.length == 4)
			l = Long.parseLong(arr[0]) * x1 + Long.parseLong(arr[1]) * x2 + Long.parseLong(arr[2]) * x3 + Long.parseLong(arr[3]);
		return l;
	}
	
	/**
	 * 根据ip获取城市名称
	 * @param p 省份
	 * @param c city集合
	 * @return 
	 */
	public static String getCity(String p, List<String> c) {
		String r = p;
		for (int i = 0; i < c.size(); i++) {
			if (!p.equals(c.get(i))) {
				r = c.get(i);
			}
		}
		return r;
	}
}
