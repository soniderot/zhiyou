package com.zy.facade.impl;

import com.zy.common.model.ZyProfile;
import com.zy.domain.profile.service.ProfileService;
import com.zy.facade.ProfileFacade;

public class ProfileFacadeImpl implements ProfileFacade {
	
	private static final int BUFFER_SIZE = 16 * 1024;

	private ProfileService profileService;

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}
	public ZyProfile findProfileById(int profileId){
		return profileService.findProfileById(profileId);
	}
	public ZyProfile checkProfileLogin(String email,String password){
		return profileService.checkProfileLogin(email, password);
	}
	public void addProfile(ZyProfile profile){
		profileService.insertProfile(profile);
	}
	
	public ZyProfile findProfileByEmail(String email){
		return profileService.findProfileByEmail(email);
	}
	
	public ZyProfile findProfileByName(String userName){
		return profileService.findProfileByName(userName);
	}
	
	public void updateProfile(ZyProfile profile){
		profileService.updateProfile(profile);
	}
}
