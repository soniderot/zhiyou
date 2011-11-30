package com.zy.domain.profile.dao;

import java.util.List;

import com.zy.common.db.BaseDao;
import com.zy.common.model.ZyEducation;

public interface EducationDAO extends BaseDao<ZyEducation, Integer>{

	public List<ZyEducation> findByUserId(Integer userId);
	public int findCountByUserId(Integer userId);
	
	public List<ZyEducation> getEducations(int schoolId,int startYear);
	
	//for endorse
	public List<ZyEducation> findByEndorse(Integer userId);
	public List<ZyEducation> findByEndorseStatus(int receiverId, short status);
}
