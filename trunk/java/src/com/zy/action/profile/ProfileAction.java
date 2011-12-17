package com.zy.action.profile;

import java.util.List;

import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;

public class ProfileAction {
	private int userid;
	private ProfileFacade profileFacade;
	private ZyProfile profile;
	private List<ZyProfile> friends;
	private List<ZyProfile> profiles;
	private SNSFacade snsFacade;
	
	

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}

	public List<ZyProfile> getFriends() {
		return friends;
	}

	public void setFriends(List<ZyProfile> friends) {
		this.friends = friends;
	}

	public List<ZyProfile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<ZyProfile> profiles) {
		this.profiles = profiles;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public ZyProfile getProfile() {
		return profile;
	}

	public void setProfile(ZyProfile profile) {
		this.profile = profile;
	}

	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String viewProfileInfo(){
		profile = profileFacade.findProfileById(userid);
		friends = snsFacade.getAllFriends(userid,0,(short)1);
		
		profiles = snsFacade.getProfilesYouMayKnow(userid);
		return "profile.info";
	}
	
	public String viewProfilePhoto(){
		return "profile.photo";
	}
	
	public String viewProfileFeed(){
		return "profile.feed";
	}
	
	public String viewProfileFriends(){
		return "profile.friend";
	}
}
