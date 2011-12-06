package com.zy.action.profile;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zy.Constants;
import com.zy.common.model.ZyProfile;
import com.zy.facade.ProfileFacade;

public class RegistrationAction extends ActionSupport {
	private ProfileFacade profileFacade;
	private String username;
	private String email;
	private String password;
	private String confirmpassword;
	private int gender;
	private int year;
	private int month;
	private int day;
	

	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String execute() {
		Date birthDate = new Date();
		birthDate.setHours(0);
		birthDate.setMinutes(0);
		birthDate.setSeconds(0);
		birthDate.setYear(year);
		birthDate.setMonth(month);
		birthDate.setDate(day);
		ZyProfile profile = new ZyProfile();
		profile.setUsername(username);
		profile.setEmail(email);
		profile.setGender((short)gender);
		profile.setPasswd(password);
		profile.setBirthdate(birthDate);
		profileFacade.addProfile(profile);
		System.out.println("newprofile.userid========"+profile.getUserid());
		ActionContext.getContext().getSession().put(Constants.USER_SESSION_KEY, profile);
	    ActionContext.getContext().getSession().put(Constants.USERID_SESSION_KEY, profile.getUserid());

		return "member.welcome";
	}

	public void validate() {
		if (getUsername() == null || getUsername().trim().equals("")) {
			addFieldError("username", "user.required");
		}
		if (email == null || email.trim().equals("")) {
			addFieldError("email", "email.required");
		}
		if (password == null || password.trim().equals("")) {
			addFieldError("password", "email.required");
		}
		if (password.equals(confirmpassword) == false) {
			addFieldError("confirmpassword", "email.notsame");
		}
		if (gender==0) {
			addFieldError("gender", "gender.required");
		}
		if (year < 0 || month < 0 || day < 0) {
			addFieldError("year", "birthdate.required");
		}
		if (month == 2 && day > 29) {
			addFieldError("day", "birthdate.notvalid");
		}
		if (month == 2 && year % 4 == 0 && day > 29) {
			addFieldError("day", "birthdate.notvalid");
		}
		
		if(profileFacade.findProfileByEmail(email)!=null){
			addFieldError("email", "email.exist");
		}
	}
}
