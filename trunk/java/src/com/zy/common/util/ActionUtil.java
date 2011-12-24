package com.zy.common.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.zy.Constants;

public class ActionUtil {

	public static String getIp() {
		return IPUtil.getIpAddr(ServletActionContext.getRequest());
	}

	public static int getSessionUserId() {
		ActionContext ctx = ActionContext.getContext();
		if(ctx==null){
			return 0;
		}
		Object uid = null;
		if(ctx != null)
		{
			uid = ctx.getSession().get(Constants.USERID_SESSION_KEY);
			if (uid == null) {
				return 0;
			}
		}
		
		return (Integer) uid;
	}
	public static int getCookieUserid()
	{
		Cookie[] cookies = ActionUtil.getRequest().getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(CookieUtil.COOKIE_NAME_USERID)) {
					return Integer.valueOf(cookies[i].getValue());
				}
			}
		}
		return 0;
	}
	
	
	public static HttpServletRequest getRequest(){
		ActionContext ctx = ActionContext.getContext();  
		HttpServletRequest request=null;
		if(ctx != null)
		{
			request=(HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		}
		return request;
	}
	
	public static HttpServletResponse getResponse(){
		ActionContext ctx = ActionContext.getContext();
		HttpServletResponse response=null;
		if(ctx != null)
		{
			response=(HttpServletResponse)ctx.get(ServletActionContext.HTTP_RESPONSE);
		}
		return response;
	}
	
	public static Map<String,Object> getSession()
	{
		synchronized (ActionUtil.class) {
			ActionContext ctx = ActionContext.getContext();
			if(ctx == null)
			{
				return null;
			}
			return ctx.getSession();
		}
	}
	
	public static void printStr(Object str) {
		HttpServletResponse resp = getResponse();
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
			out.print(str);
		} catch (IOException e) {
			LogUtil.error(e);
			throw new RuntimeException(e);
		} finally {
			if (out != null)
				out.close();
		}
	}
	
	/**
	 * @author calvin
	 * return the Web Container's application path
	 */
	public static String getWebappPath() {
	    return getRequest().getSession().getServletContext().getRealPath("/");
	}
	
	public static void copyProperties(Object distObj, Object srcObj) {
		try {
			PropertyUtils.copyProperties(distObj, srcObj);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
