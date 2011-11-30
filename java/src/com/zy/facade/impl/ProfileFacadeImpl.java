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
	public ZyProfile findBasicProfileById(int profileId){
		return profileService.findProfileById(profileId);
	}
	public boolean checkProfileLogin(String email,String password){
		return profileService.checkProfileLogin(email, password);
	}
}
