package com.zy.facade;

import com.zy.common.model.ZyProfile;

public interface ProfileFacade {

	public ZyProfile findProfileById(int profileId);
	public ZyProfile checkProfileLogin(String email,String password);
	public void addProfile(ZyProfile profile);
	public ZyProfile findProfileByEmail(String email);
	public ZyProfile findProfileByName(String username);
}
