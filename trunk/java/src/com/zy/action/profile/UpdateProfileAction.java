package com.zy.action.profile;

import java.util.Calendar;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.Constants;
import com.zy.bean.Profile;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.facade.ProfileFacade;

public class UpdateProfileAction extends ActionSupport implements ModelDriven<Profile>{
	private ProfileFacade profileFacade;
	private Profile profileform = new Profile();
	

	public Profile getProfileform() {
		return profileform;
	}

	public void setProfileform(Profile profileform) {
		this.profileform = profileform;
	}

	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String basic() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(profileform.getBirthdate());
		profileform.setYear(calendar.get(Calendar.YEAR));
		profileform.setMonth(calendar.get(Calendar.MONTH) + 1);
		profileform.setDay(calendar.get(Calendar.DAY_OF_MONTH));
		return "member.basic";
	}
	
	public String execute() {
		int profileId = ActionUtil.getSessionUserId();
		ZyProfile profile = profileFacade.findProfileById(profileId);
		ActionUtil.copyProperties(profile, profileform);
		profileFacade.updateProfile(profile);
		ActionContext.getContext().getSession().put(Constants.USER_SESSION_KEY, profile);
		return "member.picture";
	}

	@Override
	public Profile getModel() {
		ZyProfile profile = (ZyProfile) ActionContext.getContext().getSession().get(Constants.USER_SESSION_KEY);
		ActionUtil.copyProperties(profileform, profile);
		return profileform;
	}

}
