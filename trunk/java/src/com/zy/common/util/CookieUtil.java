package com.zy.common.util;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

public class CookieUtil {

	public final static String PRIVATE_KEY = "ushicookiekey";

	public final static String COOKIE_NAME = "ushicookie";
	public final static String COOKIE_NAME_USERID = "ushicookieuserid";
	public final static String COOKIE_NAME_MOBILE = "ushicookiemobile";
	public final static String COOKIE_NAME_CS = "ushicookiecs";

	public final static String COOKIE_PATH = "/";
	public final static String COOKIE_DOMAIN = "ushi.com";

	public final static int COOKIE_MAXAGE_6H = 1 * 60 * 60 * 6;// 6h
	public final static int COOKIE_MAXAGE_365D = 60 * 60 * 24 * 365;// 365 days
	public final static int COOKIE_MAXAGE_1D = 60 * 60 * 24 ;// 1 day

	/**
	 * 
	 * @param strUser
	 * @return
	 */
	private static String createCookie(String strUser) {
		strUser = strUser + "," + PRIVATE_KEY;// (A,B) A==strUser
		String str = strUser + "," + SecurityUtil.getMD5(strUser);// (A,C)
		return BASE64Util.encode(str);
	}

	public static Cookie addUserToCookie(String userName, boolean remeberMe) {
		Cookie cookie = new Cookie(COOKIE_NAME, createCookie(userName + "," + new Date()));
		// cookie.setPath(COOKIE_PATH);
		// cookie.setDomain(COOKIE_DOMAIN);
		if (remeberMe)
			cookie.setMaxAge(COOKIE_MAXAGE_365D);
		else
			cookie.setMaxAge(COOKIE_MAXAGE_6H);
		cookie.setPath("/");
		return cookie;
	}
	
	public static Cookie addUserIdToCookie(int userId) {
		Cookie cookie = new Cookie(COOKIE_NAME_USERID, userId+"");
		//cookie.setPath(COOKIE_PATH);
		// cookie.setDomain(COOKIE_DOMAIN);
		cookie.setMaxAge(COOKIE_MAXAGE_1D);
		return cookie;
	}
	
	public static Cookie addUserToMobileCookie(String userName, boolean remeberMe) {
		Cookie cookie = new Cookie(COOKIE_NAME_MOBILE, createCookie(userName + "," + new Date()));
		// cookie.setPath(COOKIE_PATH);
		// cookie.setDomain(COOKIE_DOMAIN);
		if (remeberMe)
			cookie.setMaxAge(COOKIE_MAXAGE_365D);
		else
			cookie.setMaxAge(COOKIE_MAXAGE_6H);
		return cookie;
	}
	
	public static Cookie addUserToCSCookie(String userName) {
		Cookie cookie = new Cookie(COOKIE_NAME_CS, createCookie(userName + "," + new Date()));
			cookie.setMaxAge(COOKIE_MAXAGE_1D);
		return cookie;
	}

	public static String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String emailpwd = null;
		String base64 = null;
		String forumer = null;
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(COOKIE_NAME)) {
					base64 = cookies[i].getValue();
					break;
				}
			}
			forumer = BASE64Util.decode(base64);
			String[] arr = StringUtils.split(forumer, ",");
			if (arr != null) {
				emailpwd = arr[0] + "," + arr[1];
			}
		}
		return emailpwd;
	}
	
	public static String getMobileCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String emailpwd = null;
		String base64 = null;
		String forumer = null;
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(COOKIE_NAME_MOBILE)) {
					base64 = cookies[i].getValue();
					break;
				}
			}
			forumer = BASE64Util.decode(base64);
			String[] arr = StringUtils.split(forumer, ",");
			if (arr != null) {
				emailpwd = arr[0] + "," + arr[1];
			}
		}
		return emailpwd;
	}
	
	public static String getCSCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String emailpwd = null;
		String base64 = null;
		String forumer = null;
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(COOKIE_NAME_CS)) {
					base64 = cookies[i].getValue();
					break;
				}
			}
			forumer = BASE64Util.decode(base64);
			String[] arr = StringUtils.split(forumer, ",");
			if (arr != null) {
				emailpwd = arr[0] + "," + arr[1];
			}
		}
		return emailpwd;
	}

	public static void invalidateCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (CookieUtil.COOKIE_NAME.equals(cookie.getName())) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}
	public static void invalidateMobileCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (CookieUtil.COOKIE_NAME_MOBILE.equals(cookie.getName())) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}
	
	public static void invalidatecCSCookie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (CookieUtil.COOKIE_NAME_CS.equals(cookie.getName())) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
	}
}
