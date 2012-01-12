package com.zy.action.profile;

import java.util.Random;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.SecurityUtil;
import com.zy.facade.ProfileFacade;

public class ForgetPassAction {
	private String email;
	private boolean errorFlag;
	private ProfileFacade profileFacade;
	
	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}
	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}
	public boolean isErrorFlag() {
		return errorFlag;
	}
	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String execute(){
		System.out.println("---------------------email---------------"+email);
		if(email==null||email.trim().length()==0){
			return "forgetpass";
		}
		ZyProfile profile = profileFacade.findProfileByEmail(email);
		if(profile==null){
			errorFlag = true;
		}else{
			Random r = new Random();
			String passwd = SecurityUtil.getMD5(""+r.nextLong());
			passwd = passwd.substring(0,6);
			String newPass = SecurityUtil.getMD5(passwd);
			profile.setPasswd(newPass);
			profileFacade.updateProfile(profile);
			System.out.println("------------------------newPass----------------"+newPass);
			profileFacade.sendForgetPassEmail_tx(profile.getUserid(), passwd);
			errorFlag = false;
		}
		return "forgetpass";
	}
}
