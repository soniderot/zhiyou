package com.zy.action.profile;

import com.zy.facade.ProfileFacade;

public class LoginAction {
	private ProfileFacade profileFacade;
	private String email;
	private String pass;
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}
	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String execute(){
		if(email.equals("1")){
			return "login.welcome";
		}else{
			return "login.fail";
		}
		
	}
}
