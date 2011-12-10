package com.zy.domain.profile.dao;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyProfile;



public interface ProfileDao extends BaseDao<ZyProfile, Integer> {
	public ZyProfile findProfileByEmail(String email);
	public ZyProfile findProfileByName(String userName);
}
