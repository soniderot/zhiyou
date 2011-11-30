package com.zy.action.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zy.Constants;

public class AuthorityInterceptor extends AbstractInterceptor{
	public static final String GOING_TO_URL_KEY = "GOING_TO";
	
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		Map<String, Object> session = actionContext.getSession();
		if (session != null && session.get(Constants.USER_SESSION_KEY) != null) {
			return invocation.invoke();
		}else{
			setGoingToURL(session, invocation);
			return "login";
		}
	}
	
	private void setGoingToURL(Map<String, Object> session, ActionInvocation invocation) {
		String url = "";
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		Set<String> keys = parameters.keySet();
		String paramlinks = "";
		for (Iterator<String> li = keys.iterator(); li.hasNext();) {
			String key = li.next();
			String[] value = (String[]) parameters.get(key);

			paramlinks = paramlinks + key + "=" + value[0] + "&";
		}
		url = url + request.getRequestURI();
		if (!"".equals(paramlinks)) {
			url = url + "?" + paramlinks.substring(0, paramlinks.lastIndexOf("&"));
		}
		session.put(GOING_TO_URL_KEY, url);
	}

	public void init() {

	}

	public void destroy() {
	}
}	
