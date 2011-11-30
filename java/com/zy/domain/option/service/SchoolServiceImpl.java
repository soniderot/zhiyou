package com.zy.domain.option.service;

import java.util.List;

import com.zy.common.model.ZySchool;
import com.zy.domain.option.dao.SchoolDao;

public class SchoolServiceImpl implements SchoolService{
	private SchoolDao schoolDao;
	
	public SchoolDao getSchoolDao() {
		return schoolDao;
	}

	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	public ZySchool getSchoolById(int id) {
		return this.schoolDao.load(id);
	}

	@Override
	public List<ZySchool> getSchools() {
		return this.schoolDao.getApprovedSchools();
	}
}
