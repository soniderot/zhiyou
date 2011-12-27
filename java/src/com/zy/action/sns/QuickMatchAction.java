package com.zy.action.sns;

import java.util.List;

import com.zy.bean.Profile;

public class QuickMatchAction {
	private List<Profile> profileList;
	
	
	public List<Profile> getProfileList() {
		return profileList;
	}


	public void setProfileList(List<Profile> profileList) {
		this.profileList = profileList;
	}


	public String execute() {

		return "match.search";
	}
}
