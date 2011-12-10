package com.zy.action.profile;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction {
	public String execute(){
		ActionContext.getContext().getSession().clear();
		return "public.welcome";
	}
}
