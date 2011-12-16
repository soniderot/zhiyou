package com.zy.action.profile;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

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

	public String execute() {
		int profileId = ActionUtil.getSessionUserId();
		ZyProfile profile = profileFacade.findProfileById(profileId);
		try {
			BeanUtils.copyProperties(profile, profileform);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		profileFacade.updateProfile(profile);
		return "member.picture";
	}

	@Override
	public Profile getModel() {
		// TODO Auto-generated method stub
		return profileform;
	}

}
