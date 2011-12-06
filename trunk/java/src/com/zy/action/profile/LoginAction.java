package com.zy.action.profile;

import com.opensymphony.xwork2.ActionContext;
import com.zy.Constants;
import com.zy.common.model.ZyProfile;
import com.zy.facade.ProfileFacade;

public class LoginAction extends MemberAction{
	private ProfileFacade profileFacade;
	private String email;
	private String password;

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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute(){
		if(email==null||password==null||email.trim().length()==0||password.trim().length()==0){
			if(ActionContext.getContext().getSession().get(Constants.USER_SESSION_KEY)!=null){
				return "login.welcome";
			}
			return "login.fail";
		}
		ZyProfile user = profileFacade.checkProfileLogin(email, password);
		if(user!=null){
			System.out.println("------------into welcome----------");
			ActionContext.getContext().getSession().put(Constants.USER_SESSION_KEY, user);
		    ActionContext.getContext().getSession().put(Constants.USERID_SESSION_KEY, user.getUserid());

			return "login.welcome";
		}else{
			System.out.println("------------into fail----------");
			return "login.fail";
		}
		
	}
}
