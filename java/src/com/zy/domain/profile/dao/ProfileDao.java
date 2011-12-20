package com.zy.domain.profile.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyProfile;



public interface ProfileDao extends BaseDao<ZyProfile, Integer> {
	public ZyProfile findProfileByEmail(String email);
	public ZyProfile findProfileByName(String userName);
	public List<ZyProfile> findProfileByPoint(String userIds);
}
