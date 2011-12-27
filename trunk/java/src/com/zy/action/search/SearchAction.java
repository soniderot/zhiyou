package com.zy.action.search;

import java.util.ArrayList;
import java.util.List;

import com.zy.bean.Profile;

public class SearchAction {
	private int ageFrom;
	private int ageTo;
	private short gender;
	private int highSchoolId;
	private int pageNo;
	public int getAgeFrom() {
		return ageFrom;
	}
	public int getAgeTo() {
		return ageTo;
	}
	public short getGender() {
		return gender;
	}
	public int getHighSchoolId() {
		return highSchoolId;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setAgeFrom(int ageFrom) {
		this.ageFrom = ageFrom;
	}
	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}
	public void setGender(short gender) {
		this.gender = gender;
	}
	public void setHighSchoolId(int highSchoolId) {
		this.highSchoolId = highSchoolId;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	private List<Profile> profileList;
	public List<Profile> getProfileList() {
		return profileList;
	}
	public void setProfileList(List<Profile> profileList) {
		this.profileList = profileList;
	}

	public String execute() {
		profileList = new ArrayList();
		Profile profile1 = new Profile();
		profile1.setUsername("科比1");
		profile1.setCountryname("中国");
		profileList.add(profile1);
		Profile profile2 = new Profile();
		profile2.setUsername("科比2");
		profile2.setCountryname("美国");
		profileList.add(profile2);
		return "match.search.ajax";
	}
}
