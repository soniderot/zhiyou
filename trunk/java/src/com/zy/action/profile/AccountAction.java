package com.zy.action.profile;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.SecurityUtil;
import com.zy.facade.ProfileFacade;

public class AccountAction {
	private ZyProfile profile;
	private String newpassword;
	private String confirmpassword;
	private String newusername;
	private String newemail;
	
	
	
	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getNewusername() {
		return newusername;
	}

	public void setNewusername(String newusername) {
		this.newusername = newusername;
	}

	public String getNewemail() {
		return newemail;
	}

	public void setNewemail(String newemail) {
		this.newemail = newemail;
	}

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
	
	public String update(){
		if(newpassword!=null&&newpassword.trim().length()>0){
			if(newpassword.equalsIgnoreCase(confirmpassword)){
				profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
				profile.setPasswd(SecurityUtil.getMD5(newpassword));
				profileFacade.updateProfile(profile);
			}
		}
		ActionUtil.getSession().put("user",profile);
		return "member.account";
	}
	
}
