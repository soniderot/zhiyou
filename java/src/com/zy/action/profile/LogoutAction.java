package com.zy.action.profile;

import com.opensymphony.xwork2.ActionContext;
import com.zy.common.util.CookieUtil;
import com.zy.common.util.ActionUtil;
public class LogoutAction {
	public String execute(){
		ActionContext.getContext().getSession().clear();
		CookieUtil.invalidateCookie(ActionUtil.getRequest(), ActionUtil.getResponse());
		return "public.welcome";
	}
}
