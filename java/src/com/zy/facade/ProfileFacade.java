package com.zy.facade;

import com.zy.common.model.ZyProfile;

public interface ProfileFacade {

	public ZyProfile findBasicProfileById(int profileId);
	public boolean checkProfileLogin(String email,String password);
}
