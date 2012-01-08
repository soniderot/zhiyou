package com.zy.action.profile;

import java.util.Map;

import com.zy.common.util.ActionUtil;
import com.zy.facade.ProfileFacade;

public class LandingAction {
	private String verifytoken;
	private ProfileFacade profileFacade;
	
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}


	public String getVerifytoken() {
		return verifytoken;
	}

	public void setVerifytoken(String verifytoken) {
		this.verifytoken = verifytoken;
	}

	public String execute(){
		long userId = ActionUtil.getSessionUserId();
		if(userId==0){
			return "public.welcome";
		}else{
			String[] menuSelect = new String[10];
			for(int i=0;i<10;i++){
				menuSelect[i] = "";
			}
			menuSelect[0] = "selectedItem open";
			Map<String, Object> session = ActionUtil.getSession();
			session.put("menuSelect",menuSelect);
			return "member.welcome";
		}
	}
	
	public String verify() {		
		profileFacade.verifyEmail_tx(verifytoken);
		
		return "public.welcome";
	}
}
