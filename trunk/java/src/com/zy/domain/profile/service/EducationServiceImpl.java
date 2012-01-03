package com.zy.domain.profile.service;

import java.util.List;

import com.zy.common.model.ZyEducation;
import com.zy.domain.profile.dao.EducationDAO;


public class EducationServiceImpl implements EducationService {
	private EducationDAO educationDao;
	
	public EducationDAO getEducationDao() {
		return educationDao;
	}
	
	public void setEducationDao(EducationDAO educationDao) {
		this.educationDao = educationDao;
	}
	
	@Override
	public ZyEducation getEducationByUser(int userId) {
		List<ZyEducation> userEducations = educationDao.findByUserId(userId);
		if (userEducations != null && userEducations.size() > 0) {
			return userEducations.get(0);
		}
		return null;
	}

	@Override
	public void addEducation(ZyEducation education) {
		educationDao.save(education);
	}

	@Override
	public void updateEducation(ZyEducation education) {
		educationDao.update(education);
	}
	
}
