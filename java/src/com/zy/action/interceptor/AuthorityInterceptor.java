package com.zy.action.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zy.Constants;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.CookieUtil;
import com.zy.facade.ProfileFacade;

public class AuthorityInterceptor extends AbstractInterceptor{
	public static final String GOING_TO_URL_KEY = "GOING_TO";
	
	private ProfileFacade profileFacade;
	
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		String[] menuSelect = new String[10];
		for(int i=0;i<10;i++){
			menuSelect[i] = "";
		}
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		
		if(request.getRequestURI().indexOf("landing")>0){
			System.out.println("-------------------into landing-----------");
			menuSelect[0] = "selectedItem open";
		}
		if(request.getRequestURI().indexOf("feed")>0&&(request.getQueryString()==null||request.getQueryString().indexOf("photo")<0)){
			menuSelect[1] = "selectedItem open";
		}
		if(request.getRequestURI().indexOf("message")>0){
			menuSelect[2] = "selectedItem open";
		}
		if(request.getRequestURI().indexOf("Invite")>0){
			menuSelect[3] = "selectedItem open";
		}
		if(request.getRequestURI().indexOf("getFriends")>0&&request.getRequestURI().indexOf("getFriendsEvents")<0){
			menuSelect[4] = "selectedItem open";
		}
		if(request.getRequestURI().indexOf("getEvents")>0){
			menuSelect[5] = "selectedItem open";
		}
		if(request.getRequestURI().indexOf("getFriendsEvents")>0){
			menuSelect[6] = "selectedItem open";
		}
		if(request.getRequestURI().indexOf("match")>0){
			menuSelect[7] = "selectedItem open";
		}
		if(request.getQueryString()!=null&&request.getQueryString().indexOf("photo")>0){
			menuSelect[8] = "selectedItem open";
		}
		
		Map<String, Object> session = actionContext.getSession();
		session.put("menuSelect",menuSelect);
		if (session != null && session.get(Constants.USER_SESSION_KEY) != null) {
			return invocation.invoke();
		}else{
			setGoingToURL(session, invocation);
			String value = CookieUtil.getCookie(request);
			if (StringUtils.isNotBlank(value)) {
				String[] split = value.split(",");
				String email = split[0];
				String password = split[1];
				
				ZyProfile user = profileFacade.checkProfileLogin(email, password);
				
				if(user!=null){
					if(user.getAvatar()==null||user.getAvatar().equalsIgnoreCase("/images/DEFAULT.JPG")||user.getAvatar().equalsIgnoreCase("//images/DEFAULT.JPG")){
						ActionContext.getContext().getSession().put("userlogo",null);
					}else{
						ActionContext.getContext().getSession().put("userlogo",user.getAvatar());
					}
					ActionContext.getContext().getSession().put(Constants.USER_SESSION_KEY, user);
				    ActionContext.getContext().getSession().put(Constants.USERID_SESSION_KEY, user.getUserid());		    
				    String url = (String)ActionContext.getContext().getSession().get(AuthorityInterceptor.GOING_TO_URL_KEY);
				    System.out.println("url-------------------"+url);
				    ActionUtil.getResponse().sendRedirect(url);
				    return null;
				}
			}
			
			return "landing";
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
