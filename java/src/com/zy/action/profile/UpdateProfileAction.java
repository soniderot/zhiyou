package com.zy.action.profile;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.Constants;
import com.zy.bean.Profile;
import com.zy.common.model.ZyCity;
import com.zy.common.model.ZyEducation;
import com.zy.common.model.ZyInterest;
import com.zy.common.model.ZyProfile;
import com.zy.common.model.ZySchool;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.SecurityUtil;
import com.zy.facade.EducationFacade;
import com.zy.facade.LocationFacade;
import com.zy.facade.OptionFacade;
import com.zy.facade.ProfileFacade;

public class UpdateProfileAction extends ActionSupport implements ModelDriven<Profile>{
	private ProfileFacade profileFacade;
	private EducationFacade educationFacade;
	private LocationFacade locationFacade;
	private OptionFacade optionFacade;
	
	private Profile profileform = new Profile();
	
	private String[] viewType = new String[]{"","","",""};

	private boolean errorFlag = false;
	
	
	public boolean isErrorFlag() {
		return errorFlag;
	}

	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	public String[] getViewType() {
		return viewType;
	}

	public void setViewType(String[] viewType) {
		this.viewType = viewType;
	}

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
	
	public OptionFacade getOptionFacade() {
		return optionFacade;
	}

	public void setOptionFacade(OptionFacade optionFacade) {
		this.optionFacade = optionFacade;
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
			if(user.getObjectgender()!=null){
				if (user.getObjectgender() == Constants.MALEORFEMALE) {
					profileform.setMeeting_sex1(true);
					profileform.setMeeting_sex2(true);
				} else if (user.getObjectgender() == Constants.MALE) {
					profileform.setMeeting_sex1(true);
				} else {
					profileform.setMeeting_sex2(true);
				}
			}
			if (user.getCityid() != null) {
				ZyCity city = locationFacade.getCity(user.getCityid());
				profileform.setCityid(user.getCityid());
				profileform.setCityname(city.getCityname());
			}
			if (user.getHometownid() != null) {
				ZyCity hometown = locationFacade.getCity(user.getHometownid());
				profileform.setHometownid(user.getHometownid());
				profileform.setHometownname(hometown.getCityname());
			}
			ZySchool school = educationFacade.getSchoolByUser(user.getUserid());
			if (school != null) {
				profileform.setCollegeid(school.getId());
				profileform.setCollegename(school.getSchoolname());
			}
			
			viewType[0] = "selectedItem open";
			return "member.basic";
		} else if (pageIndex == 2) {
			viewType[1] = "selectedItem open";
			return "member.picture";
		} else if (pageIndex == 3) {
			viewType[2] = "selectedItem open";
			List<ZyInterest> interests = optionFacade.getInterestsByPagination(1, 12);
			HttpServletRequest request = ActionUtil.getRequest();
			request.setAttribute("interests", interests);
			int tagCount = optionFacade.getInterestsCount();
			request.setAttribute("tagCount", tagCount);
			List<ZyInterest> selectedHobbies = new ArrayList<ZyInterest>();
			if (profileform.getHobby() != null && !"".equals(profileform.getHobby())) {
				String[] tagArr = profileform.getHobby().split(" ");
				for (int i = 0; i < tagArr.length; i++) {
					ZyInterest interest = optionFacade.getInterestById(Integer.parseInt(tagArr[i]));
					selectedHobbies.add(interest);
				}
				request.setAttribute("selectedHobbies", selectedHobbies);
			}
			return "member.interest";
		} else if (pageIndex == 4) {
			viewType[3] = "selectedItem open";
			return "member.contact";
		} else {
			return "member.info";
		}
	}
	
	public String execute() {
		int profileId = ActionUtil.getSessionUserId();
		ZyProfile profile = profileFacade.findProfileById(profileId);
		ActionUtil.copyProperties(profile, profileform);
		
		if(profile.getCityid()==null||profile.getCityid()==0){
			profile.setCityid(profileFacade.findProfileById(profileId).getCityid());
		}
		
		if(profile.getHometownid()==null||profile.getHometownid()==0){
			profile.setHometownid(profileFacade.findProfileById(profileId).getHometownid());
		}
		
		if (profileform.getMeeting_sex1() != null && profileform.getMeeting_sex2() != null) {
			if (profileform.getMeeting_sex1() && !profileform.getMeeting_sex2()) {
				profile.setObjectgender(Constants.MALE);
			} else if(!profileform.getMeeting_sex1() && profileform.getMeeting_sex2()){
				profile.setObjectgender(Constants.FEMALE);
			} else {
				profile.setObjectgender(Constants.MALEORFEMALE);
			}
		}
		if(profileform.getPasswd()!=null&&profileform.getPasswd().trim().length()>0){
			profile.setPasswd(SecurityUtil.getMD5(profileform.getPasswd()));
		}
		
		if(profileform.getEmail()!=null&&profileform.getEmail().trim().length()>0){
			ZyProfile zyProfile = profileFacade.findProfileByEmail(profileform.getEmail());
			if(zyProfile!=null&&zyProfile.getUserid()!=profileId){
				errorFlag = true;
				profileform.setPageIndex(3);
				return "member.update";
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
