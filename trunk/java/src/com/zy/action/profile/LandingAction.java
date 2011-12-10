package com.zy.action.profile;

import com.zy.common.util.ActionUtil;

public class LandingAction {
	public String execute(){
		long userId = ActionUtil.getSessionUserId();
		if(userId==0){
			return "public.welcome";
		}else{
			return "member.welcome";
		}
	}
}
