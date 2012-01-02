package com.zy.action.profile;

import java.util.Calendar;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.Constants;
import com.zy.bean.Profile;
import com.zy.common.model.ZyCity;
import com.zy.common.model.ZyEducation;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZySchool;
import com.zy.common.util.ActionUtil;
import com.zy.facade.EducationFacade;
import com.zy.facade.LocationFacade;
import com.zy.facade.ProfileFacade;

public class UpdateProfileAction extends ActionSupport implements ModelDriven<Profile>{
	private ProfileFacade profileFacade;
	private EducationFacade educationFacade;
	private LocationFacade locationFacade;
	
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

	public EducationFacade getEducationFacade() {
		return educationFacade;
	}

	public void setEducationFacade(EducationFacade educationFacade) {
		this.educationFacade = educationFacade;
	}

	public LocationFacade getLocationFacade() {
		return locationFacade;
	}

	public void setLocationFacade(LocationFacade locationFacade) {
		this.locationFacade = locationFacade;
	}
	
	public String basic() {

		int pageIndex = profileform.getPageIndex() == null? 0: profileform.getPageIndex();
		pageIndex ++;
		if (pageIndex == 1) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(profileform.getBirthdate());
			profileform.setYear(calendar.get(Calendar.YEAR));
			profileform.setMonth(calendar.get(Calendar.MONTH) + 1);
			profileform.setDay(calendar.get(Calendar.DAY_OF_MONTH));
			ZyProfile user = (ZyProfile)ActionUtil.getSession().get(Constants.USER_SESSION_KEY);
			if (user.getObjectgender() == Constants.MALEORFEMALE) {
				profileform.setMeeting_sex1(true);
				profileform.setMeeting_sex2(true);
			} else if (user.getObjectgender() == Constants.MALE) {
				profileform.setMeeting_sex1(true);
			} else {
				profileform.setMeeting_sex2(true);
			}
			if (user.getCityid() != null) {
				ZyCity city = locationFacade.getCity(user.getCityid());
				profileform.setCityname(city.getCityname());
			}
			if (user.getHometownid() != null) {
				ZyCity hometown = locationFacade.getCity(user.getHometownid());
				profileform.setHometownname(hometown.getCityname());
			}
			ZySchool school = educationFacade.getSchoolByUser(user.getUserid());
			if (school != null) {
				profileform.setCollegeid(school.getId());
				profileform.setCollegename(school.getSchoolname());
			}
			return "member.basic";
		} else if (pageIndex == 2) {
			return "member.picture";
		} else if (pageIndex == 3) {
			return "member.interest";
		} else if (pageIndex == 4) {
			return "member.contact";
		} else {
			return "member.info";
		}
	}
	
	public String execute() {
		int profileId = ActionUtil.getSessionUserId();
		ZyProfile profile = profileFacade.findProfileById(profileId);
		ActionUtil.copyProperties(profile, profileform);
		
		if (profileform.getMeeting_sex1() != null && profileform.getMeeting_sex2() != null) {
			if (profileform.getMeeting_sex1() && !profileform.getMeeting_sex2()) {
				profile.setObjectgender(Constants.MALE);
			} else if(!profileform.getMeeting_sex1() && profileform.getMeeting_sex2()){
				profile.setObjectgender(Constants.FEMALE);
			} else {
				profile.setObjectgender(Constants.MALEORFEMALE);
			}
		}
		profileFacade.updateProfile(profile);
		// save school message
		if (profileform.getCollegeid() != null && profileform.getCollegeid() != 0) {
			ZyEducation education = new ZyEducation();
			education.setUserid(profileId);
			education.setSchoolid(profileform.getCollegeid());
			education.setSchoolname(profileform.getCollegename());
			educationFacade.addEducation(education);
		}
		ActionContext.getContext().getSession().put(Constants.USER_SESSION_KEY, profile);

		return "member.update";
	}

	@Override
	public Profile getModel() {
		ZyProfile profile = (ZyProfile) ActionContext.getContext().getSession().get(Constants.USER_SESSION_KEY);
		ActionUtil.copyProperties(profileform, profile);
		return profileform;
	}

}
