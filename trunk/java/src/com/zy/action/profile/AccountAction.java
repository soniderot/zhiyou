package com.zy.action.profile;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.SecurityUtil;
import com.zy.common.util.StringUtil;
import com.zy.facade.ProfileFacade;

public class AccountAction {
	private ZyProfile profile;
	private String username;
	private String email;
	private String passwd;
	private String newPasswd1;
	private String newPasswd2;
	

	public String getUsername() {
		return username;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getNewPasswd1() {
		return newPasswd1;
	}

	public String getNewPasswd2() {
		return newPasswd2;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void setNewPasswd1(String newPasswd1) {
		this.newPasswd1 = newPasswd1;
	}

	public void setNewPasswd2(String newPasswd2) {
		this.newPasswd2 = newPasswd2;
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
		profile = profileFacade.findProfileById(ActionUtil.getSessionUserId());
		if(!StringUtil.isNull(email) && !email.equals(profile.getEmail())){
			profile.setEmail(email);
		}
		if(!StringUtil.isNull(username) && !username.equals(profile.getUsername())){
			profile.setUsername(username);
		}
		if (newPasswd1 != null && newPasswd1.trim().length() > 0) {
			if (newPasswd1.equalsIgnoreCase(newPasswd2)) {
				profile.setPasswd(SecurityUtil.getMD5(newPasswd1));
			}
		}
		profileFacade.updateProfile(profile);
		ActionUtil.getSession().put("user", profile);
		ActionUtil.getRequest().setAttribute("result", "success");
		return "member.account";
	}

	
}
