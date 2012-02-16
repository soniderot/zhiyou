package com.zy.action.profile;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.facade.ProfileFacade;

public class AccountAction {
	private ZyProfile profile;
	
	public ZyProfile getProfile() {
		return profile;
	}

	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}
	private ProfileFacade profileFacade;
	
	
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String execute(){
		profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
		return "member.account";
	}
	
}
